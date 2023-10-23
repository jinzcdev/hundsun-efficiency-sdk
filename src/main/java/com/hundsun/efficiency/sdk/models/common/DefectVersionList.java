package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class DefectVersionList {

    private int id;
    @SerializedName("patch_apply_num")
    private String patchApplyNum;
    @SerializedName("sprint_id")
    private int sprintId;
    @SerializedName("create_time")
    private Date createTime;
    @SerializedName("version_type")
    private int versionType;
    @SerializedName("sprint_version")
    private String sprintVersion;
    @SerializedName("sprint_name")
    private String sprintName;
    @SerializedName("application_ids")
    private String applicationIds;
    @SerializedName("project_id")
    private String projectId;

}
