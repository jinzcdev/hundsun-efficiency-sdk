package com.hundsun.efficiency.sdk.profile;


import lombok.Data;

/**
 * 用于配置 HTTP 请求的一些参数，如超时时间、协议、请求方法等。请求方法仅支持 POST 和 GET。
 * 默认使用 POST 请求方式。
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description HTTP Profile 配置类
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */

@Data
public class HttpProfile {

    public static final String REQ_HTTPS = "https://";

    public static final String REQ_HTTP = "http://";

    public static final String REQ_POST = "POST";

    public static final String REQ_GET = "GET";

    public static final int TM_MINUTE = 60;

    /**
     * 默认的请求方法
     */
    private String reqMethod;

    private String protocol;

    private int connTimeout;

    private int readTimeout;

    private int writeTimeout;

    public HttpProfile() {
        this.reqMethod = HttpProfile.REQ_POST;
        this.protocol = HttpProfile.REQ_HTTPS;
        this.connTimeout = HttpProfile.TM_MINUTE;
    }

}
