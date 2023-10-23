package com.hundsun.efficiency.sdk.models.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Actions {

    @SerializedName("patch_submit")
    private boolean patchSubmit;

    @SerializedName("patch_dev_approve")
    private boolean patchDevApprove;

    @SerializedName("patch_copy")
    private boolean patchCopy;

    @SerializedName("patch_archive")
    private boolean patchArchive;

    @SerializedName("patch_approve_return")
    private boolean patchApproveReturn;

    @SerializedName("patch_create")
    private boolean patchCreate;

    @SerializedName("patch_customer_approve")
    private boolean patchCustomerApprove;

    @SerializedName("patch_update")
    private boolean patchUpdate;

    @SerializedName("patch_product_approve")
    private boolean patchProductApprove;

    @SerializedName("patch_test_approve")
    private boolean patchTestApprove;

    @SerializedName("upgrade_record")
    private boolean upgradeRecord;

    @SerializedName("patch_cancel")
    private boolean patchCancel;

    @SerializedName("update_completion_status")
    private boolean updateCompletionStatus;

    @SerializedName("patch_delete")
    private boolean patchDelete;
}
