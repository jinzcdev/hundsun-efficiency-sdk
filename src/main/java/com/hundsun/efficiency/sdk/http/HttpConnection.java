package com.hundsun.efficiency.sdk.http;


import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author jinzc51705
 * @version 1.0.0
 * @description HTTP 请求类的
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
public class HttpConnection {

    private static final OkHttpClient clientSingleton = new OkHttpClient();
    private final OkHttpClient client;

    public HttpConnection(Integer connTimeout, Integer readTimeout, Integer writeTimeout) {
        this.client = clientSingleton.newBuilder()
                .connectTimeout(connTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .build();
        Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);
    }


    public Response doRequest(Request request) throws IOException {
        return this.client.newCall(request).execute();
    }

    public Response getRequest(String url) throws EfficiencySDKException, IOException {
        Request request = null;
        try {
            request = new Request.Builder().url(url).get().build();
        } catch (IllegalArgumentException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }

        return this.doRequest(request);
    }

    public Response getRequest(String url, Headers headers) throws EfficiencySDKException, IOException {
        Request request = null;
        try {
            request = new Request.Builder().url(url).headers(headers).get().build();
        } catch (IllegalArgumentException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }

        return this.doRequest(request);
    }

    public Response postRequest(String url, String body) throws EfficiencySDKException, IOException {
        MediaType contentType = MediaType.parse("application/json");
        Request request = null;
        try {
            request = new Request.Builder().url(url).post(
                    RequestBody.create(contentType, body)).build();
        } catch (IllegalArgumentException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }

        return this.doRequest(request);
    }

    public Response postRequest(String url, String body, Headers headers)
            throws EfficiencySDKException, IOException {
        String strContentType = headers.get("Content-Type");
        MediaType contentType = null;
        if (strContentType == null) {
            contentType = MediaType.parse("application/json");
        } else {
            contentType = MediaType.parse(strContentType);
        }
        Request request = null;
        try {
            request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(contentType, body))
                    .headers(headers)
                    .build();
        } catch (IllegalArgumentException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }

        return this.doRequest(request);
    }

    public Response postRequest(String url, byte[] body, Headers headers)
            throws EfficiencySDKException, IOException {
        String strContentType = headers.get("Content-Type");
        MediaType contentType = null;
        if (strContentType == null) {
            contentType = MediaType.parse("application/json");
        } else {
            MediaType.parse(strContentType);
        }
        Request request = null;
        try {
            request =
                    new Request.Builder()
                            .url(url)
                            .post(RequestBody.create(contentType, body))
                            .headers(headers)
                            .build();
        } catch (IllegalArgumentException e) {
            throw new EfficiencySDKException(e.getClass().getName() + "-" + e.getMessage());
        }

        return this.doRequest(request);
    }
}
