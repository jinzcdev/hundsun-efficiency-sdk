package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class TaskItems extends AbstractModel {

    public static final int STATUS_COMPLETE = 2; // 已完成
    public static final int STATUS_CANCEL = 3; // 已作废

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
    private String name;
    private int priority;
    @SerializedName("priority_name")
    private String priorityName;
    private int status;
    @SerializedName("status_name")
    private String statusName;
    @SerializedName("sub_status")
    private int subStatus;
    @SerializedName("sub_status_name")
    private String subStatusName;
    @SerializedName("task_type")
    private int taskType;
    @SerializedName("task_type_name")
    private String taskTypeName;
    @SerializedName("sprint_name")
    private String sprintName;
    @SerializedName("sprint_version")
    private String sprintVersion;
    @SerializedName("git_review")
    private String gitReview;
    @SerializedName("project_manager_id")
    private String projectManagerId;
    @SerializedName("status_update_time")
    private Date statusUpdateTime;
    @SerializedName("project_id")
    private int projectId;
    @SerializedName("project_name")
    private String projectName;
    @SerializedName("project_no")
    private String projectNo;
    @SerializedName("product_name")
    private String productName;
    private String abbreviatename;
    @SerializedName("product_no")
    private String productNo;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("estimate_workload")
    private double estimateWorkload;
    @SerializedName("estimate_start_time")
    private String estimateStartTime;
    @SerializedName("estimate_finish_time")
    private Date estimateFinishTime;
    @SerializedName("assignee_id")
    private String assigneeId;
    @SerializedName("assignee_name")
    private String assigneeName;
    @SerializedName("distributor_id")
    private String distributorId;
    @SerializedName("distributor_name")
    private String distributorName;
    @SerializedName("patch_nums")
    private String patchNums;
    @SerializedName("real_workload")
    private double realWorkload;
    /**
     * 任务单的实际完成时间
     */
    @SerializedName("real_finish_time")
    private Date realFinishTime;
    @SerializedName("finish_percentage")
    private double finishPercentage;
    @SerializedName("story_number")
    private String storyNumber;
    @SerializedName("story_numbers")
    private String storyNumbers;
    @SerializedName("pre_task")
    private String preTask;
    @SerializedName("pre_task_name")
    private String preTaskName;
    @SerializedName("available_status")
    private String availableStatus;
    @SerializedName("expired_information")
    private String expiredInformation;
    @SerializedName("task_number")
    private String taskNumber;
    @SerializedName("cancel_reason")
    private String cancelReason;
    private String deadline;
    @SerializedName("sprint_id")
    private int sprintId;
    @SerializedName("milestone_ap_id")
    private String milestoneApId;
    @SerializedName("task_source")
    private int taskSource;
    @SerializedName("task_source_name")
    private String taskSourceName;
    @SerializedName("risk_status")
    private String riskStatus;
    @SerializedName("risk_id")
    private String riskId;
    @SerializedName("risk_name")
    private String riskName;
    @SerializedName("copy_to")
    private String copyTo;
    @SerializedName("copy_to_list")
    private List<String> copyToList;
    @SerializedName("application_ids")
    private String applicationIds;
    @SerializedName("application_names")
    private String applicationNames;
    private String suggestion;
    private String remark;
    @SerializedName("task_remark")
    private String taskRemark;
    @SerializedName("excutor_id")
    private String excutorId;
    @SerializedName("excutor_name")
    private String excutorName;
    private String description;
    @SerializedName("edit_description")
    private String editDescription;
    @SerializedName("modified_file")
    private String modifiedFile;
    @SerializedName("self_test_desc")
    private String selfTestDesc;
    private String branch;
    @SerializedName("test_record_id")
    private int testRecordId;
    @SerializedName("test_workload")
    private int testWorkload;
    @SerializedName("zip_package_path")
    private String zipPackagePath;
    @SerializedName("integration_desc")
    private String integrationDesc;
    @SerializedName("app_versions")
    private String appVersions;
    @SerializedName("app_version_names")
    private String appVersionNames;
    @SerializedName("integrate_type")
    private int integrateType;
    @SerializedName("review_mark")
    private int reviewMark;
    @SerializedName("reviewer_id")
    private String reviewerId;
    @SerializedName("reviewer_name")
    private String reviewerName;
    @SerializedName("review_result")
    private int reviewResult;
    @SerializedName("expire_mark")
    private String expireMark;
    @SerializedName("relation_dtolist")
    private List<RelationDtolist> relationDtolist;
    @SerializedName("patch_num_list")
    private List<String> patchNumList;
    @SerializedName("dev_integrate_branch")
    private String devIntegrateBranch;
    @SerializedName("test_integrate_branch")
    private String testIntegrateBranch;
    @SerializedName("format_code")
    private boolean formatCode;
    @SerializedName("use_dev_pipeline")
    private boolean useDevPipeline;
    @SerializedName("use_test_pipeline")
    private boolean useTestPipeline;
    @SerializedName("integrate_success_time")
    private int integrateSuccessTime;
    @SerializedName("integrate_fail_time")
    private int integrateFailTime;
    @SerializedName("use_wait_to_test")
    private boolean useWaitToTest;
    @SerializedName("is_blade")
    private int isBlade;
    @SerializedName("is_review")
    private int isReview;
    private String reviewer;
    @SerializedName("review_people_name")
    private String reviewPeopleName;
    @SerializedName("review_finish_time")
    private String reviewFinishTime;
    @SerializedName("require_test_review_finish_time")
    private String requireTestReviewFinishTime;
    @SerializedName("real_test_review_finish_time")
    private String realTestReviewFinishTime;
    @SerializedName("review_remark")
    private String reviewRemark;
    @SerializedName("review_member_list")
    private List<String> reviewMemberList;
    @SerializedName("story_version_status")
    private String storyVersionStatus;
    @SerializedName("overdue_mark")
    private String overdueMark;
    @SerializedName("sprint_status")
    private int sprintStatus;
    @SerializedName("test_return_number")
    private int testReturnNumber;
    @SerializedName("test_back_number")
    private int testBackNumber;
    @SerializedName("test_result")
    private String testResult;
    @SerializedName("jira_id")
    private String jiraId;
    @SerializedName("case_writer_id")
    private String caseWriterId;
    @SerializedName("case_writer_name")
    private String caseWriterName;
    @SerializedName("require_case_finish_time")
    private String requireCaseFinishTime;
    @SerializedName("real_case_finish_time")
    private String realCaseFinishTime;
    @SerializedName("no_code_submission")
    private boolean noCodeSubmission;
    @SerializedName("need_test")
    private boolean needTest;
    @SerializedName("real_test_finish_time")
    private Date realTestFinishTime;
    @SerializedName("real_test_workload")
    private double realTestWorkload;
    @SerializedName("require_finish_time")
    private Date requireFinishTime;
    @SerializedName("test_package_name")
    private String testPackageName;
    @SerializedName("operate_bill")
    private String operateBill;
    @SerializedName("release_version")
    private String releaseVersion;
    @SerializedName("module_name")
    private String moduleName;
    @SerializedName("first_integrate_time")
    private Date firstIntegrateTime;
    @SerializedName("last_integrate_time")
    private Date lastIntegrateTime;
    @SerializedName("last_integrate_man_no")
    private String lastIntegrateManNo;
    @SerializedName("last_integrate_man_name")
    private String lastIntegrateManName;
    @SerializedName("assign_dev_mark")
    private int assignDevMark;
    @SerializedName("task_response_id")
    private String taskResponseId;
    @SerializedName("defect_response_id")
    private String defectResponseId;
    @SerializedName("defect_response_name")
    private String defectResponseName;
    @SerializedName("task_response_name")
    private String taskResponseName;
    @SerializedName("team_name")
    private String teamName;
    @SerializedName("audit_description")
    private String auditDescription;
    @SerializedName("audit_work_hours")
    private double auditWorkHours;
    @SerializedName("cancel_reason_type")
    private String cancelReasonType;
    @SerializedName("generated_workload")
    private String generatedWorkload;
    @SerializedName("modify_summary")
    private String modifySummary;
    @SerializedName("test_type")
    private String testType;
    @SerializedName("test_back_reason")
    private String testBackReason;
    @SerializedName("test_method")
    private String testMethod;
    @SerializedName("design_description")
    private String designDescription;
    private String customers;
    @SerializedName("customer_names")
    private String customerNames;
    @SerializedName("real_start_time")
    private Date realStartTime;
    /**
     * 该时间格式为：2023-06-30,2023-09-30
     * 因为无法被直接解析为日期类型
     */
    @SerializedName("promise_dates")
    private String promiseDates;
    @SerializedName("relation_task_list")
    private String relationTaskList;
    @SerializedName("has_relation_task")
    private String hasRelationTask;
    @SerializedName("from_jira")
    private int fromJira;
    @SerializedName("test_content")
    private String testContent;
    @SerializedName("release_status")
    private int releaseStatus;
    @SerializedName("table_modify")
    private String tableModify;
    @SerializedName("switch_menu_config")
    private String switchMenuConfig;
    @SerializedName("compatible_desc")
    private String compatibleDesc;
    @SerializedName("publish_desc")
    private String publishDesc;
    @SerializedName("out_program")
    private String outProgram;
    @SerializedName("audit_time")
    private Date auditTime;
    @SerializedName("real_finish_time_first")
    private Date realFinishTimeFirst;
    @SerializedName("estimate_commit_test_time")
    private String estimateCommitTestTime;
    @SerializedName("first_commit_test_time")
    private Date firstCommitTestTime;
    @SerializedName("real_commit_test_time")
    private Date realCommitTestTime;
    private Actions actions;
    @SerializedName("fix_bug")
    private String fixBug;
    @SerializedName("has_files")
    private String hasFiles;
    @SerializedName("pre_task_detail")
    private String preTaskDetail;
}
