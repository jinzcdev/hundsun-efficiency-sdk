package com.hundsun.efficiency.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class QueryTaskByConditionV2Request extends AbstractModel {
    @SerializedName("page_size")
    private int pageSize;
    @SerializedName("page_no")
    private int pageNo;
    @SerializedName("story_nos")
    private String storyNos;
    @SerializedName("sprint_ids")
    private List<String> sprintIds;
    @SerializedName("product_id")
    private int productId;
    @SerializedName("extra_show_list")
    private List<String> extraShowList;
}
