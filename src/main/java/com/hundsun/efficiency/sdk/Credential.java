package com.hundsun.efficiency.sdk;


import lombok.Data;

/**
 * @author jinzc51705
 * @version 1.0.0
 * @description 用户登录凭证
 * @date 2023/8/7
 * @company 恒生电子股份有限公司
 */
@Data
public class Credential {

    private String username;
    private String password;
    private String token;

    public Credential() {
    }

    public Credential(String token) {
        this("", "", token);
    }

    public Credential(String username, String password) {
        this(username, password, "");
    }

    public Credential(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

}
