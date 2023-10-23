package com.hundsun.efficiency.sdk.models;

import com.hundsun.efficiency.sdk.AbstractModel;
import com.hundsun.efficiency.sdk.models.common.PatchItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * @author jinzc51705
 * @version 1.0.0
 * @description 条件查询补丁列表响应模型
 * @date 2023/8/9
 * @company 恒生电子股份有限公司
 */

// 不是使用 @Data 注解是因为其会覆盖父类的 toString 方法
@Getter
@Setter
public class QueryPatchByConditionResponse extends AbstractModel {
    private List<PatchItems> items;
    private int total;
}


