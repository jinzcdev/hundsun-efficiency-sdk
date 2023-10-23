package com.hundsun.efficiency.sdk;

import com.hundsun.efficiency.sdk.client.EfficiencyClient;
import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import com.hundsun.efficiency.sdk.models.GetUserInfoByTokenRequest;
import com.hundsun.efficiency.sdk.models.GetUserInfoByTokenResponse;
import com.hundsun.efficiency.sdk.models.QueryPatchByConditionRequest;
import com.hundsun.efficiency.sdk.models.QueryPatchByConditionResponse;
import com.hundsun.efficiency.sdk.util.CredentialPropertiesManager;
import com.hundsun.efficiency.sdk.util.CredentialUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;


public class EfficiencyClientTest {


    private static Credential credential;

    @BeforeAll
    static void initializeCredential() throws EfficiencySDKException {
        String token = CredentialUtil.getToken();
        credential = new Credential(token);
        Assertions.assertNotNull(token);
    }


    @Test
    @Disabled
    void testProperties() {
        CredentialPropertiesManager credentialPropertiesManager = null;
        try {
            credentialPropertiesManager = CredentialPropertiesManager.getInstance();
        } catch (EfficiencySDKException e) {
            throw new RuntimeException(e);
        }
        credentialPropertiesManager.setUsername("xxxxxx");
        credentialPropertiesManager.setPassword("xxxxxx");
        credentialPropertiesManager.setToken("xxxxxx");
    }

    @Test
    void testGetUserInfoByTokenResponse() throws EfficiencySDKException {

        EfficiencyClient client = new EfficiencyClient(credential);
        GetUserInfoByTokenResponse userInfo = client.getUserInfoByToken(new GetUserInfoByTokenRequest());
        System.out.println(userInfo);
    }

    @Test
    void testQueryPatchByConditionResponse() throws EfficiencySDKException, ParseException {

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

        req.setExpectReleaseStartTime(dateFormat.parse("2023-07-03 00:00:00"));
        req.setExpectReleaseEndTime(dateFormat.parse("2023-08-16 00:00:00"));

        QueryPatchByConditionResponse resp = client.queryPatchByCondition(req);

        Assertions.assertNotNull(resp);

        System.out.println(resp);
    }

}
