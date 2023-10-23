package com.hundsun.efficiency.sdk.models.common;

import lombok.Data;

@Data
public
class SwitchOutSystem {
    private boolean dataHepUsable;
    private String cqBathPath;
    private boolean tsUsable;
    private boolean isOutSystem;
    private boolean onlineUsable;
    private boolean itsm3Usable;
    private boolean jyUsable;
    private String onlineOuterBasePath;
    private boolean jiraUsable;
    private boolean bladeUsable;
}
