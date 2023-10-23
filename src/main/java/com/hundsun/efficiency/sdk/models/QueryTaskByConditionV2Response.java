package com.hundsun.efficiency.sdk.models;


import com.hundsun.efficiency.sdk.AbstractModel;
import com.hundsun.efficiency.sdk.models.common.TaskItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryTaskByConditionV2Response extends AbstractModel {
    private List<TaskItems> items;
    private int total;
}
