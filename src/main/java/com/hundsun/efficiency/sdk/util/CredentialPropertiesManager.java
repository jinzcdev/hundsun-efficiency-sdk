package com.hundsun.efficiency.sdk.util;

import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


/**
 * 配置文件主要包含对用户的账户、密码与效能平台的 Token
 * 该文件的存储地址默认为用户目录下的 .hundsun-efficiency.properties 文件中
 * 此类在本 SDK 封装库中被设置为单例的。
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 登录凭证配置文件的管理类
 * @date 2023/8/9
 * @company 恒生电子股份有限公司
 */

@Slf4j
public class CredentialPropertiesManager {

    private static final String CONFIG_FILE = ".hundsun-efficiency.properties";
    private static final String TOKEN_KEY = "login.token";
    private static final String USERNAME_KEY = "login.username";
    private static final String PASSWORD_KEY = "login.password";

    private static CredentialPropertiesManager credentialPropertiesManager;
    private final Properties properties;

    private CredentialPropertiesManager() throws EfficiencySDKException {
        Path path = Paths.get(getConfigFilePath());
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new EfficiencySDKException("配置文件创建失败: " + e.getMessage());
            }
        }
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(getConfigFilePath());
            properties.load(input);
            input.close();
        } catch (IOException e) {
            log.error("配置文件加载失败: " + e.getMessage());
        }
    }

    public static CredentialPropertiesManager getInstance() throws EfficiencySDKException {
        if (credentialPropertiesManager == null) {
            credentialPropertiesManager = new CredentialPropertiesManager();
        }
        return credentialPropertiesManager;
    }

    public String getToken() {
        return properties.getProperty(TOKEN_KEY);
    }

    public void setToken(String token) {
        properties.setProperty(TOKEN_KEY, token);
        saveProperties();
    }

    public String getUsername() {
        return properties.getProperty(USERNAME_KEY);
    }

    public void setUsername(String username) {
        properties.setProperty(USERNAME_KEY, username);
        saveProperties();
    }

    public String getPassword() {
        return properties.getProperty(PASSWORD_KEY);
    }

    public void setPassword(String password) {
        properties.setProperty(PASSWORD_KEY, password);
        saveProperties();
    }

    private void saveProperties() {
        try {
            FileOutputStream output = new FileOutputStream(getConfigFilePath());
            properties.store(output, null);
            output.close();
        } catch (IOException e) {
            log.error("配置文件保存失败: " + e.getMessage());
        }
    }

    private String getConfigFilePath() {
        String configPath = System.getProperty("config");
        if (configPath == null) {
            configPath = System.getProperty("user.home");
        }
        return configPath + "/" + CONFIG_FILE;
    }

}
