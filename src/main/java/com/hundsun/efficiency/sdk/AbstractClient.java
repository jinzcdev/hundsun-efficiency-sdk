package com.hundsun.efficiency.sdk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import com.hundsun.efficiency.sdk.http.HttpConnection;
import com.hundsun.efficiency.sdk.profile.HttpProfile;
import lombok.Data;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;

/**
 * 抽象客户端类必须被继承，封装基础的客户端请求类的通用方法，如定制化的内部请求方法，
 * 效能平台的用户鉴权方式是通过在请求中添加 Authorization 头部字段。如果应用不同的
 * 平台，则可以在子类中重写 doRequest 方法。
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 客户端抽象类
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
@Data
public abstract class AbstractClient {

    public static final int HTTP_RSP_OK = 200;
    public Gson gson;
    private Credential credential;
    private String endpoint;
    private HttpProfile httpProfile;
    private HttpConnection httpConnection;

    protected AbstractClient(Credential credential, String endpoint) {
        this.credential = credential;
        this.endpoint = endpoint;
        this.httpProfile = new HttpProfile();
        this.httpConnection = new HttpConnection(
                httpProfile.getConnTimeout(),
                httpProfile.getReadTimeout(),
                httpProfile.getWriteTimeout()
        );
        this.gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    protected String internalRequest(AbstractModel request, String path)
            throws EfficiencySDKException {
        return internalRequest(request, path, this.httpProfile.getReqMethod());
    }


    protected String internalRequest(AbstractModel request, String path, String requestMethod)
            throws EfficiencySDKException {
        String endpoint = this.getEndpoint();
        Response okRsp = null;

        try {
            okRsp = doRequest(endpoint + path, request, requestMethod);
        } catch (IOException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }
        // 处理 HTTP 请求响应
        if (okRsp.code() != AbstractClient.HTTP_RSP_OK) {
            throw new EfficiencySDKException(okRsp.message(), String.valueOf(okRsp.code()));
        }
        String strResp = "";

        try {
            if (okRsp.body() != null) {
                strResp = okRsp.body().string();
            }
        } catch (IOException e) {
            throw new EfficiencySDKException("Cannot transfer response body to string, because Content-Length is too large, or Content-Length and stream length disagree.",
                    endpoint.getClass().getName());
        }

        // 处理响应结果
        JsonErrorResponseModel errorObj = null;
        try {
            errorObj = gson.fromJson(strResp, new TypeToken<JsonErrorResponseModel>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            String msg = "json is not a valid representation for an object of type";
            throw new EfficiencySDKException(msg, e.getClass().getName());
        }
        if (errorObj != null && errorObj.getError() != null) {
            throw new EfficiencySDKException(errorObj.getErrorDescription(), errorObj.getError());
        }
        return strResp;
    }

    private Response doRequest(String endpointPath, AbstractModel request, String reqMethod)
            throws EfficiencySDKException, IOException {

        String url = this.httpProfile.getProtocol() + endpointPath;
        String requestPayload = reqMethod.equals(HttpProfile.REQ_POST)
                ? AbstractModel.toJsonString(request) : "";

        String token = this.credential.getToken();
        Headers.Builder hb = new Headers.Builder();
        hb.add("Authorization", token);
        Headers headers = hb.build();

        if (reqMethod.equals(HttpProfile.REQ_GET)) {
            String strParam = AbstractModel.toParamStr(request);
            return this.httpConnection.getRequest(url + "?" + strParam, headers);
        } else if (reqMethod.equals(HttpProfile.REQ_POST)) {
            return this.httpConnection.postRequest(url, requestPayload, headers);
        } else {
            throw new EfficiencySDKException("Method only support (GET, POST)");
        }
    }
}
