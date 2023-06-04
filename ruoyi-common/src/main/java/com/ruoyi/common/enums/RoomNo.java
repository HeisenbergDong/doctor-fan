package com.ruoyi.common.enums;

/**
 * HongBing.D
 */
public enum RoomNo {
    CONSULT_1("consult-1", "咨询室"),
    WEAR_1("wear-1", "摘戴室"),
    CHECK_1("check-1", "检查室"),
    OPTOMETRY_1("optometry-1", "验光室"),
    DIAGNOSIS_1("diagnosis-1", "诊室1-1"),
    DIAGNOSIS_2("diagnosis-2", "诊室1-2"),
    DIAGNOSIS_3("diagnosis-3", "诊室3-1"),
    DIAGNOSIS_4("diagnosis-4", "诊室3-1"),
    DISPATCH_1("dispatch-1", "分诊室");

    private final String code;
    private final String info;

    RoomNo(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
