package com.hundsun.efficiency.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GetStoryRelatedListByNumsRequest extends AbstractModel {
    @SerializedName("story_number_list")
    private List<String> storyNumberList;
}
