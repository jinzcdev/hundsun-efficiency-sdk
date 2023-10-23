package com.hundsun.efficiency.sdk.example;

import com.hundsun.efficiency.sdk.Credential;
import com.hundsun.efficiency.sdk.client.EfficiencyClient;
import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import com.hundsun.efficiency.sdk.models.QueryPatchByConditionRequest;
import com.hundsun.efficiency.sdk.models.QueryPatchByConditionResponse;
import com.hundsun.efficiency.sdk.util.CredentialUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

public class EfficiencySdkTestExample {

    public static void main(String[] args) throws EfficiencySDKException, ParseException {
        // 获取用户登录的 Token
        String token = CredentialUtil.getToken();

        // 创建登录凭证对象
        Credential credential = new Credential(token);

        // 创建客户端对象
        EfficiencyClient client = new EfficiencyClient(credential);

        // 创建请求对象
        QueryPatchByConditionRequest req = new QueryPatchByConditionRequest();

        // 构建请求对象
        req.setProductIds(Collections.singletonList(4000134));
        req.setPatchSwitch(1);
        req.setProductNo("LS0015");
        req.setProductNames(Collections.singletonList("Oplus"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        req.setExpectReleaseStartTime(dateFormat.parse("2023-08-15 00:00:00"));
        req.setExpectReleaseEndTime(dateFormat.parse("2023-08-15 00:00:00"));

        // 发起请求
        QueryPatchByConditionResponse resp = client.queryPatchByCondition(req);

        // 打印响应对象
        System.out.println(resp);
    }
}
