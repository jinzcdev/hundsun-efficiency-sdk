package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RelationDtolist {
    @SerializedName("story_id")
    private int storyId;
    @SerializedName("story_name")
    private String storyName;
    @SerializedName("story_number")
    private String storyNumber;
    @SerializedName("story_description")
    private String storyDescription;
    @SerializedName("story_version_status")
    private int storyVersionStatus;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("story_type")
    private String storyType;
    @SerializedName("story_type_name")
    private String storyTypeName;
    @SerializedName("module_id")
    private String moduleId;
    @SerializedName("module_name")
    private String moduleName;
    @SerializedName("jira_id")
    private String jiraId;
    @SerializedName("promise_date")
    private String promiseDate;
    private String suggestion;
    @SerializedName("test_analysis")
    private String testAnalysis;
    @SerializedName("project_id")
    private String projectId;
}
