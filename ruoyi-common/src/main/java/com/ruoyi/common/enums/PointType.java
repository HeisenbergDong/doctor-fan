package com.ruoyi.common.enums;

public enum PointType {
    ZERO("0", "折扣"), ONE("1", "积分");

    private final String code;
    private final String info;

    PointType(String code, String info)
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
