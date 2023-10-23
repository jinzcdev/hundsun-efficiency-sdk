package com.hundsun.efficiency.sdk.exception;

/**
 * @author jinzc51705
 * @version 1.0.0
 * @description 效能平台客户端 SDK 业务异常类
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
public class EfficiencySDKException extends Exception {
    private static final long serialVersionUID = 1L;


    private final String errorCode;

    public EfficiencySDKException(String message) {
        this(message, "");
    }

    public EfficiencySDKException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String toString() {
        String errorCode = this.getErrorCode();
        if (errorCode != null && errorCode.length() > 0) {
            return "[EfficiencySDKException]"
                    + " code: "
                    + this.getErrorCode()
                    + " message: "
                    + this.getMessage();
        }
        return "[EfficiencySDKException]"
                + " message: "
                + this.getMessage();
    }
}
