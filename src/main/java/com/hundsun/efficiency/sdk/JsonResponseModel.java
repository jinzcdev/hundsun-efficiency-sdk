package com.hundsun.efficiency.sdk;


import lombok.Data;


/**
 * 根据效能平台的请求响应结果，定义此模型类
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 统一的响应模型
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
@Data
public class JsonResponseModel<T> {

    private int code;

    private T data;

    private String message;

}
