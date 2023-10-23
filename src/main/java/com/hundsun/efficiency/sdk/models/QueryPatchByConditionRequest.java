package com.hundsun.efficiency.sdk.models;


import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @author jinzc51705
 * @version 1.0.0
 * @description 条件搜索补丁的请求模型
 * @date 2023/8/9
 * @company 恒生电子股份有限公司
 */
@Data
public class QueryPatchByConditionRequest extends AbstractModel {

    @SerializedName("config_item_list")
    private List<String> configItemList;
    @SerializedName("menu_switch")
    private int menuSwitch;
    @SerializedName("content_search")
    private String contentSearch;
    @SerializedName("menu_type")
    private String menuType;
    @SerializedName("template_name")
    private String templateName;
    @SerializedName("page_size")
    private int pageSize;
    @SerializedName("page_no")
    private int pageNo;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("product_ids")
    private List<Integer> productIds;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("patch_switch")
    private int patchSwitch;
    @SerializedName("creator_id")
    private String creatorId;
    @SerializedName("status_list")
    private List<String> statusList;
    @SerializedName("customer_appromer_id_list")
    private List<String> customerAppromerIdList;
    @SerializedName("product_appromer_id_list")
    private List<String> productAppromerIdList;
    @SerializedName("dev_appromer_id_list")
    private List<String> devAppromerIdList;
    @SerializedName("test_appromer_id_list")
    private List<String> testAppromerIdList;
    @SerializedName("dev_leader_id")
    private String devLeaderId;
    @SerializedName("test_responsible_ids")
    private List<String> testResponsibleIds;
    @SerializedName("related_persons")
    private List<String> relatedPersons;
    @SerializedName("client_ids")
    private List<String> clientIds;
    @SerializedName("story_num_list")
    private List<String> storyNumList;
    @SerializedName("patch_nums")
    private String patchNums;
    @SerializedName("patch_nums_type")
    private boolean patchNumsType;
    @SerializedName("severity_level_list")
    private List<String> severityLevelList;
    @SerializedName("defect_type")
    private String defectType;
    @SerializedName("patch_reason")
    private String patchReason;
    @SerializedName("create_start_time")
    private String createStartTime;
    @SerializedName("create_end_time")
    private String createEndTime;
    @SerializedName("apply_repair_start_time")
    private String applyRepairStartTime;
    @SerializedName("apply_repair_end_time")
    private String applyRepairEndTime;
    @SerializedName("expect_test_start_time")
    private String expectTestStartTime;
    @SerializedName("expect_test_end_time")
    private String expectTestEndTime;
    @SerializedName("expect_submit_start_time")
    private String expectSubmitStartTime;
    @SerializedName("expect_submit_end_time")
    private String expectSubmitEndTime;
    @SerializedName("expect_release_start_time")
    private Date expectReleaseStartTime;
    @SerializedName("expect_release_end_time")
    private Date expectReleaseEndTime;
    @SerializedName("expect_upgrade_start_time")
    private String expectUpgradeStartTime;
    @SerializedName("expect_upgrade_end_time")
    private String expectUpgradeEndTime;
    @SerializedName("real_upgrade_start_time")
    private String realUpgradeStartTime;
    @SerializedName("real_upgrade_end_time")
    private String realUpgradeEndTime;
    @SerializedName("archive_start_time")
    private String archiveStartTime;
    @SerializedName("archive_end_time")
    private String archiveEndTime;
    @SerializedName("customer_approve_start_time")
    private String customerApproveStartTime;
    @SerializedName("customer_approve_end_time")
    private String customerApproveEndTime;
    @SerializedName("product_approve_start_time")
    private String productApproveStartTime;
    @SerializedName("product_approve_end_time")
    private String productApproveEndTime;
    @SerializedName("test_approve_start_time")
    private String testApproveStartTime;
    @SerializedName("test_approve_end_time")
    private String testApproveEndTime;
    @SerializedName("patch_completion_status")
    private List<String> patchCompletionStatus;
    @SerializedName("patch_plan_version_ids")
    private List<String> patchPlanVersionIds;
    @SerializedName("customer_suggestion")
    private String customerSuggestion;
    @SerializedName("product_suggestion")
    private String productSuggestion;
    @SerializedName("dev_suggestion")
    private String devSuggestion;
    @SerializedName("test_suggestion")
    private String testSuggestion;
    @SerializedName("dev_approve_start_time")
    private String devApproveStartTime;
    @SerializedName("dev_approve_end_time")
    private String devApproveEndTime;
    @SerializedName("project_id")
    private String projectId;
    @SerializedName("sprint_ids")
    private List<String> sprintIds;
    @SerializedName("product_no")
    private String productNo;
    @SerializedName("product_names")
    private List<String> productNames;
    @SerializedName("sort_by")
    private String sortBy;
    private String order;
}