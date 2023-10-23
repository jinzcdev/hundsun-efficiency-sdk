package com.hundsun.efficiency.sdk.util;

import com.hundsun.efficiency.sdk.Credential;
import com.hundsun.efficiency.sdk.client.EfficiencyClient;
import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import com.hundsun.efficiency.sdk.http.HttpConnection;
import com.hundsun.efficiency.sdk.models.GetUserInfoByTokenRequest;
import com.hundsun.efficiency.sdk.models.GetUserInfoByTokenResponse;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 通过用户名和密码获取登录凭证 token
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 效能登录凭证工具类
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
public class CredentialUtil {

    private static final CredentialPropertiesManager credentialProperties;

    static {
        try {
            credentialProperties = CredentialPropertiesManager.getInstance();
        } catch (EfficiencySDKException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 通过配置获取登录凭证 token，并验证当前凭证的有效性，如果已失效则重新使用用户名和密码模拟登录获取新的登录凭证 token
     *
     * @return token 用户登录凭证
     * @throws EfficiencySDKException
     */
    public static String getToken() throws EfficiencySDKException {
        String token = credentialProperties.getToken();
        if (token != null && isTokenValid(token)) {
            return token;
        }

        String username = credentialProperties.getUsername();
        String password = credentialProperties.getPassword();

        if (username == null || password == null) {
            throw new EfficiencySDKException("默认配置文件中缺失 login.username 或者 login.password 参数");
        }
        try {
            token = loginEfficiency(username, password);
        } catch (EfficiencySDKException | IOException e) {
            throw new EfficiencySDKException(e.getMessage() + ", 用户名或密码可能错误");
        }
        credentialProperties.setToken(token);

        return token;
    }

    /**
     * 通过用户名和密码模拟登录效能，获取登录凭证 token
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户登录凭证 token
     * @throws EfficiencySDKException
     * @throws IOException
     */
    public static String loginEfficiency(String username, String password) throws EfficiencySDKException, IOException {

        HttpConnection httpConnection = new HttpConnection(10, 10, 10);

        // 请求获取回话 Cookie 和 lt 参数
        Response response = httpConnection
                .getRequest("https://hs-cas.hundsun.com/cas/login?service=https://dev.hundsun.com/frameV2/pms/workbench");
        String responseStr = response.body().string();
        String regex = "name=\"lt\" value=\"(.*)\" />";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(responseStr);

        if (!matcher.find()) {
            throw new EfficiencySDKException("lt 参数解析失败");
        }
        String lt = matcher.group(1);
        String cookie = response.header("Set-Cookie");
        response.close();


        // 请求获取 Ticket
        Headers headers = new Headers.Builder()
                .add("Content-Type", "application/x-www-form-urlencoded")
                .add("Cookie", cookie)
                .build();
        String ticketReqUrl = "https://hs-cas.hundsun.com/cas/login?service=https://dev.hundsun.com/frameV2/pms/workbench";
        String body = String.format("username=%s&password=%s&submit=&lt=%s&execution=e1s1&_eventId=submit", username, password, lt);
        response = httpConnection.postRequest(
                ticketReqUrl,
                body,
                headers);

        String ticket = response.request().url().queryParameter("ticket");
        response.close();

        // 获取 Token
        headers = new Headers.Builder()
                .add("Content-Type", "application/json")
                .add("Cookie", cookie)
                .build();
        body = String.format("{\"service\":\"https://dev.hundsun.com/frameV2/pms/workbench\",\"ticket\":\"%s\"}", ticket);
        response = httpConnection.postRequest(
                "https://dev.hundsun.com/hepucs/auth/casLogin",
                body,
                headers);
        responseStr = response.body().string();
        response.close();
        // 从 "access_token":"xxxxxxxxxxx" 中解析出 token
        matcher = Pattern.compile("\"access_token\":\"([a-zA-Z0-9]*)\"").matcher(responseStr);
        if (!matcher.find()) {
            throw new EfficiencySDKException("Token 解析失败");
        }
        return matcher.group(1);
    }

    /**
     * 创建效能请求客户端，使用 getUserInfoByTokenResponse 接口验证 Token 是否仍有效
     *
     * @param token 用户登录凭证
     * @return true 表示有效，false 表示无效
     */
    public static boolean isTokenValid(String token) {
        Credential credential = new Credential(token);
        EfficiencyClient client = new EfficiencyClient(credential);
        try {
            GetUserInfoByTokenResponse userInfo = client.getUserInfoByToken(new GetUserInfoByTokenRequest());
            if (userInfo != null && userInfo.getUserId() != null) {
                return true;
            }
        } catch (EfficiencySDKException e) {
            return false;
        }
        return false;
    }

}
