package com.hundsun.efficiency.sdk.models;


import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import com.hundsun.efficiency.sdk.models.common.SwitchOutSystem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * @author jinzc51705
 * @version 1.0.0
 * @description 根据Token获取用户信息响应模型
 * @date 2023/8/9
 * @company 恒生电子股份有限公司
 */
@Getter
@Setter
public class GetUserInfoByTokenResponse extends AbstractModel {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_no")
    private String userNo;
    @SerializedName("org_id")
    private String orgId;
    @SerializedName("org_code")
    private String orgCode;
    @SerializedName("org_name")
    private String orgName;
    private List<String> functions;
    @SerializedName("product_authority")
    private List<String> productAuthority;
    @SerializedName("project_authority")
    private List<String> projectAuthority;
    private List<String> behaviors;
    private List<String> roles;
    @SerializedName("project_manager")
    private boolean projectManager;
    @SerializedName("switch_out_system")
    private SwitchOutSystem switchOutSystem;
    private boolean admin;
    @SerializedName("has_pro_manage")
    private boolean hasProManage;

}

