package com.hundsun.efficiency.sdk;

import com.google.gson.*;

import java.lang.reflect.Field;
import java.util.Map;


/**
 * 该类的作用是对请求和响应模型做抽象，以便于在请求和响应时做统一的处理。
 * 如在类中定义将参数转为 json 对象的方法等。
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 请求模型的抽象类
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
public abstract class AbstractModel {

    public static <O extends AbstractModel> String toJsonString(O obj) {
        return toJsonObject(obj).toString();
    }

    /**
     * 若请求方式为 GET，则需要将参数转为字符串的形式，形如：&key1=val1&key2=val2
     *
     * @param obj AbstractModel 的子类
     * @return 参数字段转 GET 请求字符串
     */
    public static <O extends AbstractModel> String toParamStr(O obj) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        StringBuilder paramStr = new StringBuilder();
        JsonObject jopublic = gson.toJsonTree(obj).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jopublic.entrySet()) {
            Object fo = null;
            String key = entry.getKey();
            try {
                String fieldName = toCamelCase(key);
                Field f = obj.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                fo = f.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fo instanceof AbstractModel) {
                throw new RuntimeException("GET 请求参数仅支持基础类型，不支持嵌套对象或数组");
            } else {
                String val = entry.getValue().getAsString().trim();
                if (val.length() > 0) {
                    paramStr.append("&").append(key).append("=").append(val);
                }
            }
        }
        if (paramStr.length() == 0) {
            return "";
        }
        return paramStr.substring(1);
    }

    /**
     * 将参数字段转换为 json 对象
     *
     * @param obj AbstractModel 的子类
     * @return 转换后的结果
     */
    private static <O extends AbstractModel> JsonObject toJsonObject(O obj) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        JsonObject joall = new JsonObject();
        JsonObject jopublic = gson.toJsonTree(obj).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jopublic.entrySet()) {
            Object fo = null;
            String key = entry.getKey();
            try {
                String fieldName = toCamelCase(key);
                Field f = obj.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                fo = f.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fo instanceof AbstractModel) {
                joall.add(key, toJsonObject((AbstractModel) fo));
            } else {
                joall.add(key, entry.getValue());
            }
        }
        return joall;
    }

    public static <O> O fromJsonString(String json, Class<O> cls) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, cls);
    }

    private static String toCamelCase(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("_");

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.append(words[i].toLowerCase());
            } else {
                result.append(words[i].substring(0, 1).toUpperCase());
                result.append(words[i].substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return toJsonObject(this).toString();
    }
}
