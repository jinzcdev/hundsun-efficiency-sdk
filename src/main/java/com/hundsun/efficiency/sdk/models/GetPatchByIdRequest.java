package com.hundsun.efficiency.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.hundsun.efficiency.sdk.AbstractModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPatchByIdRequest extends AbstractModel {

    @SerializedName("id")
    private int id;
}