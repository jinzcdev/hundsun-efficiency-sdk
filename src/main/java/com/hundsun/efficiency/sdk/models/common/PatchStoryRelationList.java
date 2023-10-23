package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class PatchStoryRelationList {
    private int id;
    @SerializedName("create_time")
    private Date createTime;
    @SerializedName("creator_id")
    private String creatorId;
    @SerializedName("creator_name")
    private String creatorName;
    @SerializedName("story_id")
    private int storyId;
    @SerializedName("patch_apply_num")
    private String patchApplyNum;
    @SerializedName("dependence_type")
    private int dependenceType;
    @SerializedName("story_name")
    private String storyName;
    @SerializedName("story_number")
    private String storyNumber;
    @SerializedName("story_status")
    private int storyStatus;
    @SerializedName("story_type")
    private int storyType;
}
