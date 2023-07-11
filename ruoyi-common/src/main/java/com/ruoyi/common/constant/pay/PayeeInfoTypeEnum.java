package com.ruoyi.common.constant.pay;

import com.ruoyi.common.utils.StringUtils;

public enum PayeeInfoTypeEnum {

    alipayUserId("ALIPAY_USER_ID", "支付宝会员的用户 ID"),
    alipayLogonId("ALIPAY_LOGON_ID", "支付宝登录号，支持邮箱和手机号格式");

    private String code;
    private String desc;

    PayeeInfoTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 通过code取枚举
     *
     * @param value
     * @return
     */
    public static PayeeInfoTypeEnum getTypeByCode(String value) {
        if (StringUtils.isNull(value)) {
            return null;
        }
        for (PayeeInfoTypeEnum enums : PayeeInfoTypeEnum.values()) {
            if (enums.getCode().equalsIgnoreCase(value)) {
                return enums;
            }
        }
        return null;
    }
}
