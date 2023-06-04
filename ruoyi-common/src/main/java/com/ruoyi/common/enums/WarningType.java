package com.ruoyi.common.enums;

public enum WarningType {
    ZERO("0", "预约"), ONE("1", "提醒");

    private final String code;
    private final String info;

    WarningType(String code, String info)
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
