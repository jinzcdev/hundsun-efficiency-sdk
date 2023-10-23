package com.hundsun.efficiency.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetStoryRelatedListByNumsResponse extends AbstractModel {

    @SerializedName("story_nos")
    private String storyNos;
}
