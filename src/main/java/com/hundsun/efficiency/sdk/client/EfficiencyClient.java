package com.hundsun.efficiency.sdk.client;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hundsun.efficiency.sdk.AbstractClient;
import com.hundsun.efficiency.sdk.Credential;
import com.hundsun.efficiency.sdk.JsonResponseModel;
import com.hundsun.efficiency.sdk.exception.EfficiencySDKException;
import com.hundsun.efficiency.sdk.models.*;
import com.hundsun.efficiency.sdk.profile.HttpProfile;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;

/**
 * 该类中的方法与效能平台的接口相对应，方法的返回类型与效能平台接口返回字段与格式保持一致
 * 除了个别接口，接口返回的结果通常会由 JsonResponseModel 类封装
 *
 * @author jinzc51705
 * @version 1.0.0
 * @description 效能平台请求的 SDK 客户端
 * @date 2023/8/9
 * @company 恒生电子股份有限公司
 */
public class EfficiencyClient extends AbstractClient {

    /**
     * 效能访问域名
     */
    private static final String endpoint = "dev.hundsun.com";


    /**
     * 通过登录凭证初始化客户端
     *
     * @param credential
     */
    public EfficiencyClient(Credential credential) {
        super(credential, EfficiencyClient.endpoint);
    }


    /**
     * 通过用户 Token 获取用户信息
     *
     * @param req
     * @throws EfficiencySDKException
     */
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


    /**
     * 该接口根据搜索条件查询补丁项
     *
     * @param req
     * @return
     * @throws EfficiencySDKException
     */
    public QueryPatchByConditionResponse queryPatchByCondition(QueryPatchByConditionRequest req) throws EfficiencySDKException {

        // 添加默认参数
        req.setConfigItemList(Arrays.asList(
                "expect_release_time",
                "dev_leader_id",
                "severity_level_list"));
        req.setMenuSwitch(1);
        req.setMenuType("patchPanel");
        req.setPageSize(2000);
        req.setPageNo(1);
        req.setProductIds(Collections.singletonList(4000134));
        req.setPatchSwitch(1);
        req.setProductNo("LS0015");
        req.setProductNames(Collections.singletonList("Oplus"));

        JsonResponseModel<QueryPatchByConditionResponse> rsp = null;
        String rspStr = "";
        try {
            Type type = new TypeToken<JsonResponseModel<QueryPatchByConditionResponse>>() {
            }.getType();
            rspStr = this.internalRequest(req, "/heppm/patch/queryByCondition");
            rsp = gson.fromJson(rspStr, type);
        } catch (JsonSyntaxException e) {
            throw new EfficiencySDKException("response message: " + rspStr + ".\n Error message: " + e.getMessage());
        }
        return rsp.getData();
    }


    /**
     * 通过补丁 ID 查询补丁单
     *
     * @param req
     * @return
     * @throws EfficiencySDKException
     */
    public GetPatchByIdResponse getPatchById(GetPatchByIdRequest req) throws EfficiencySDKException {
        JsonResponseModel<GetPatchByIdResponse> rsp = null;
        String rspStr = "";
        try {
            Type type = new TypeToken<JsonResponseModel<GetPatchByIdResponse>>() {
            }.getType();
            rspStr = this.internalRequest(req, "/heppm/patch/getById");
            rsp = gson.fromJson(rspStr, type);
        } catch (JsonSyntaxException e) {
            throw new EfficiencySDKException("response message: " + rspStr + ".\n Error message: " + e.getMessage());
        }
        return rsp.getData();
    }

    /**
     * 查询补丁单中的某个补丁详情前（即补丁说明、关联需求单、关联任务单、关联补丁、申请单附件操作日志），
     * 需要先通过该接口获取获取关联列表 story_number_list，将其作为参数做具体的详情数据的请求，如：<p>
     * 1. 关联任务单，通过 queryByConditionV2 接口传入 story_number_lis 获取 <p>
     * 2. 关联请求单，通过 getStoryMenuListV3 接口传入 story_number_lis 获取
     * <p>这个接口的返回值直接以 String 类型中作为 data，因此需要单独封装一下请求响应结果</p>
     *
     * @param req
     * @return
     * @throws EfficiencySDKException
     */
    public GetStoryRelatedListByNumsResponse getStoryRelatedListByNums(GetStoryRelatedListByNumsRequest req) throws EfficiencySDKException {
        JsonResponseModel<String> rsp = null;
        String rspStr = "";
        try {
            Type type = new TypeToken<JsonResponseModel<String>>() {
            }.getType();
            rspStr = this.internalRequest(req, "/heppm/story/getStoryRelatedListByNums");
            rsp = gson.fromJson(rspStr, type);
        } catch (JsonSyntaxException e) {
            throw new EfficiencySDKException("response message: " + rspStr + ".\n Error message: " + e.getMessage());
        }
        GetStoryRelatedListByNumsResponse resp = new GetStoryRelatedListByNumsResponse();
        resp.setStoryNos(rsp.getData());
        return resp;
    }


    /**
     * 该接口查询某个补丁项的关联任务单
     *
     * @param req
     * @return
     * @throws EfficiencySDKException
     */
    public QueryTaskByConditionV2Response queryTaskByConditionV2(QueryTaskByConditionV2Request req) throws EfficiencySDKException {

        // 添加默认参数 (根据官网请求解析得到，暂不知含义)
        req.setExtraShowList(Arrays.asList(
                "excutor_name",
                "require_finish_time",
                "story_numbers"
        ));
        req.setPageSize(2000);
        req.setPageNo(1);

        JsonResponseModel<QueryTaskByConditionV2Response> rsp = null;
        String rspStr = "";
        try {
            Type type = new TypeToken<JsonResponseModel<QueryTaskByConditionV2Response>>() {
            }.getType();
            rspStr = this.internalRequest(req, "/heppm/task/queryByConditionV2");
            rsp = gson.fromJson(rspStr, type);
        } catch (JsonSyntaxException e) {
            throw new EfficiencySDKException("response message: " + rspStr + ".\n Error message: " + e.getMessage());
        }
        return rsp.getData();
    }

}

