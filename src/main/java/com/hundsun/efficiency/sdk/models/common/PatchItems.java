package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PatchItems extends AbstractModel {

    // 补丁单状态为“作废”
    public static final int STATUS_CANCEL = 6;

    @SerializedName("operator_code")
    private String operatorCode;
    @SerializedName("user_no")
    private String userNo;
    @SerializedName("user_real_name")
    private String userRealName;
    @SerializedName("user_token")
    private String userToken;
    @SerializedName("cur_rights_group")
    private String curRightsGroup;
    @SerializedName("creator_name")
    private String creatorName;
    @SerializedName("creator_id")
    private String creatorId;
    @SerializedName("create_time")
    private Date createTime;
    @SerializedName("update_time")
    private Date updateTime;
    @SerializedName("filed_value")
    private String filedValue;
    @SerializedName("filed_value_dtolist")
    private String filedValueDtolist;
    private int id;
    @SerializedName("client_dep_name")
    private String clientDepName;
    @SerializedName("sub_system_name")
    private String subSystemName;
    @SerializedName("file_dto_list")
    private List<String> fileDtoList;
    /**
     * 产品补丁编号
     */
    @SerializedName("number")
    private String number;
    @SerializedName("product_id")
    private int productId;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("client_id")
    private int clientId;
    @SerializedName("customer_appromer_id")
    private String customerAppromerId;
    @SerializedName("customer_appromer_name")
    private String customerAppromerName;
    private int status;
    @SerializedName("apply_repair_time")
    private Date applyRepairTime;
    @SerializedName("patch_reason")
    private int patchReason;
    @SerializedName("severity_level")
    private int severityLevel;
    @SerializedName("story_relation_list")
    private String storyRelationList;
    @SerializedName("story_id_list")
    private List<String> storyIdList;
    @SerializedName("current_version")
    private String currentVersion;
    @SerializedName("product_appromer_id")
    private String productAppromerId;
    @SerializedName("product_appromer_name")
    private String productAppromerName;
    @SerializedName("test_appromer_id")
    private String testAppromerId;
    @SerializedName("test_appromer_name")
    private String testAppromerName;
    @SerializedName("dev_appromer_id")
    private String devAppromerId;
    @SerializedName("dev_appromer_name")
    private String devAppromerName;
    @SerializedName("dev_leader_id")
    private String devLeaderId;
    @SerializedName("dev_leader_name")
    private String devLeaderName;
    @SerializedName("patch_plan_version")
    private String patchPlanVersion;
    @SerializedName("defect_version")
    private String defectVersion;
    @SerializedName("expect_release_time")
    private Date expectReleaseTime;
    @SerializedName("version_type")
    private int versionType;
    @SerializedName("defect_type")
    private int defectType;
    @SerializedName("test_responsible_id")
    private String testResponsibleId;
    @SerializedName("test_responsible_name")
    private String testResponsibleName;
    private String description;
    @SerializedName("customer_suggestion")
    private String customerSuggestion;
    @SerializedName("product_suggestion")
    private String productSuggestion;
    @SerializedName("test_suggestion")
    private String testSuggestion;
    @SerializedName("dev_suggestion")
    private String devSuggestion;
    @SerializedName("updater_id")
    private String updaterId;
    @SerializedName("updater_name")
    private String updaterName;
    @SerializedName("fixed_version")
    private String fixedVersion;
    @SerializedName("related_person")
    private String relatedPerson;
    @SerializedName("related_person_name")
    private String relatedPersonName;
    @SerializedName("expect_upgrade_time")
    private String expectUpgradeTime;
    @SerializedName("expect_submit_time")
    private String expectSubmitTime;
    @SerializedName("test_response_person")
    private String testResponsePerson;
    @SerializedName("test_response_person_name")
    private String testResponsePersonName;
    @SerializedName("expect_test_time")
    private String expectTestTime;
    @SerializedName("real_upgrade_time")
    private String realUpgradeTime;
    @SerializedName("archive_time")
    private String archiveTime;
    @SerializedName("customer_approve_time")
    private Date customerApproveTime;
    @SerializedName("product_approve_time")
    private Date productApproveTime;
    @SerializedName("dev_approve_time")
    private String devApproveTime;
    @SerializedName("test_approve_time")
    private String testApproveTime;
    private String remark;
    @SerializedName("problem_cause")
    private String problemCause;
    @SerializedName("defect_cause")
    private String defectCause;
    private String content;
    @SerializedName("sub_unmodify_version")
    private String subUnmodifyVersion;
    @SerializedName("unmodify_version_cause")
    private String unmodifyVersionCause;
    @SerializedName("associate_version")
    private String associateVersion;
    @SerializedName("defect_response_analysis")
    private String defectResponseAnalysis;
    @SerializedName("improve_measure")
    private String improveMeasure;
    @SerializedName("modify_description")
    private String modifyDescription;
    @SerializedName("is_mail")
    private String isMail;
    @SerializedName("address_list")
    private List<String> addressList;
    @SerializedName("copy_to_list")
    private List<String> copyToList;
    @SerializedName("patch_story_nums")
    private String patchStoryNums;
    @SerializedName("version_lis")
    private String versionLis;
    @SerializedName("current_version_list")
    private List<CurrentVersionList> currentVersionList;
    @SerializedName("current_version_ids")
    private String currentVersionIds;
    @SerializedName("patch_plan_version_list")
    private List<PatchPlanVersion> patchPlanVersionList;
    @SerializedName("patch_plan_version_ids")
    private String patchPlanVersionIds;
    @SerializedName("defect_version_list")
    private List<DefectVersionList> defectVersionList;
    @SerializedName("defect_version_ids")
    private String defectVersionIds;
    @SerializedName("fixed_version_list")
    private List<FixedVersion> fixedVersionList;
    @SerializedName("fixed_version_ids")
    private String fixedVersionIds;
    @SerializedName("status_name")
    private String statusName;
    @SerializedName("relation_story_num")
    private String relationStoryNum;
    @SerializedName("client_name")
    private String clientName;
    private Actions actions;
    @SerializedName("apply_type")
    private String applyType;
    @SerializedName("patch_id")
    private String patchId;
    @SerializedName("is_patch_copy")
    private String isPatchCopy;
    @SerializedName("patch_completion_status")
    private int patchCompletionStatus;
    @SerializedName("release_status")
    private int releaseStatus;
    @SerializedName("severity_level_name")
    private String severityLevelName;
    @SerializedName("defect_type_name")
    private String defectTypeName;
    @SerializedName("version_type_name")
    private String versionTypeName;
    @SerializedName("release_status_name")
    private String releaseStatusName;
    @SerializedName("patch_reason_name")
    private String patchReasonName;
    private List<String> subsystems;
    @SerializedName("client_dep_num")
    private String clientDepNum;
    @SerializedName("story_numbers")
    private String storyNumbers;
    @SerializedName("application_ids")
    private String applicationIds;
    @SerializedName("application_names")
    private String applicationNames;
    @SerializedName("sub_system_names")
    private String subSystemNames;
    @SerializedName("application_id_list")
    private List<String> applicationIdList;
    @SerializedName("patch_story_relation_list")
    private List<PatchStoryRelationList> patchStoryRelationList;

}
