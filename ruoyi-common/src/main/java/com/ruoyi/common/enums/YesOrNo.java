package com.ruoyi.common.enums;

public enum YesOrNo {
    NO("0", "不是"), YES("1", "是");

    private final String code;
    private final String info;

    YesOrNo(String code, String info)
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
