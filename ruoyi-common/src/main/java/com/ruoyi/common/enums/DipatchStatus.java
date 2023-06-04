package com.ruoyi.common.enums;

public enum DipatchStatus {
    ZERO("0", "排队中"), ONE("1", "就诊中"), TWO("2", "已完成");

    private final String code;
    private final String info;

    DipatchStatus(String code, String info)
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
