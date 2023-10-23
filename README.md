# 恒生电子效能平台请求 SDK

## 客户端说明

“效能”请求客户端的主体功能：在本地模拟登录，并在本地模拟页面中的数据请求。模拟请求的核心在于获取用户的登录凭证 Token。

由于是单机程序，用户的登录凭证存储在本地配置文件中，配置文件默认为**用户目录**下的 `.hundsun-efficiency.properties`，
该文件的位置也可以通过 Java 参数 `-Dconfig {YOUR_PATH}` 的形式指定。

配置文件由以下字段组成：

```properties
login.username=xxxxxx (效能平台用户名)
login.password=xxxxxx (效能平台密码)
login.token=xxxxxx (效能平台登录凭证，该凭证通过用户名与密码登录后自动更新)
```

单独调用 `String token = CredentialUtil.getToken();` 获取登录凭证时，会优先使用 `login.token`
字段，如果该字段不存在或者为空，则使用 `login.username` 和 `login.password`
字段进行登录，并将新的 token 更新到配置文件中，若密码错误则提示错误异常。具体用法参考下述样例。

## 使用用例

为了便于在不同服务中使用"效能"请求工具，减少功能耦合，该工具类被封装为单独的模块，可作为"效能"请求平台SDK，可以通过以下方式导入：

```xml
<dependency>
    <groupId>com.hundsun</groupId>
    <artifactId>efficiency-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

具体可查看测试类中 `package com.hundsun.efficiency.sdk;` 包下的源代码：

```java
public class EfficiencySdkTestExample {

    public static void main(String[] args) throws EfficiencySDKException, ParseException {
        String token = CredentialUtil.getToken();
        Credential credential = new Credential(token);
        EfficiencyClient client = new EfficiencyClient(credential);

        QueryPatchByConditionRequest req = new QueryPatchByConditionRequest();

        req.setConfigItemList(Arrays.asList("expect_release_time", "dev_leader_id", "severity_level_list"));
        req.setMenuSwitch(1);
        req.setMenuType("patchPanel");
        req.setPageSize(20);
        req.setPageNo(1);
        req.setProductIds(Collections.singletonList(4000134));
        req.setPatchSwitch(1);
        req.setProductNo("LS0015");
        req.setProductNames(Collections.singletonList("Oplus"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        req.setExpectReleaseStartTime(dateFormat.parse("2023-08-15 00:00:00"));
        req.setExpectReleaseEndTime(dateFormat.parse("2023-08-15 00:00:00"));

        QueryPatchByConditionResponse resp = client.queryPatchByCondition(req);

    }
}
```

## 添加新的请求

在 `com.hundsun.efficiency.sdk.models` 包下添加新的请求模型类（请求模型类和响应模型类应该一一对应），继承 `AbstractModel`
类，并请求客户端中添加新的请求方法，如下：

```java
public class EfficiencyClient extends AbstractClient {

    // ...

    public GetUserInfoByTokenResponse getUserInfoByToken(GetUserInfoByTokenRequest req) throws EfficiencySDKException {
        GetUserInfoByTokenResponse rsp = null;
        String rspStr = "";
        try {
            Type type = new TypeToken<GetUserInfoByTokenResponse>() {
            }.getType();
            rspStr = this.internalRequest(req, "/heppm/user/getUserInfoByToken", HttpProfile.REQ_GET);
            rsp = gson.fromJson(rspStr, type);
        } catch (JsonSyntaxException e) {
            throw new EfficiencySDKException("response message: " + rspStr + ".\n Error message: " + e.getMessage());
        }
        return rsp;
    }
}


```

## 引用

### Json 格式转换工具

由于需要将请求数据封装成 JavaBean，使用了第三方的转化方法

1. [在线JSON转Java实体类—LZL在线工具](https://www.lzltool.com/JsonToJava)
2. [驼峰下划线互转](https://www.json.cn/json/hump2under.html)
