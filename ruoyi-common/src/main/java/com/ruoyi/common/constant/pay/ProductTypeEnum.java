package com.ruoyi.common.constant.pay;

import com.ruoyi.common.utils.StringUtils;

public enum ProductTypeEnum {

    /**
     * 1、PAY-THIRD|第三方
     * 2、PAY-CHAILV|差旅产品
     * 3、PAY-LIAOYANG|疗休养产品
     * 4、PAY-TONGQIN|通勤产品
     * 5、PAY-TONGXIN|通信产品
     */
    ThirdPartyOrderWater("00", "PAY-THIRD", "第三方"),
    ChaiLvOrderWater("01", "PAY-CHAILV", "差旅产品"),
    LiaoXiuYangOrderWater("02", "PAY-LIAOYANG", "疗休养产品"),
    TongQinOrderWater("03", "PAY-TONGQIN", "通勤产品"),
    TongXinOrderWater("04", "PAY-TONGXIN", "通信产品");

    private String id;
    private String code;
    private String desc;

    ProductTypeEnum(String id, String code, String desc) {
        this.id = id;
        this.code = code;
        this.desc = desc;
    }

    public String getId() {
        return id;
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
    public static ProductTypeEnum getTypeByCode(String value) {
        if (StringUtils.isNull(value)) {
            return null;
        }
        for (ProductTypeEnum enums : ProductTypeEnum.values()) {
            if (enums.getCode().equalsIgnoreCase(value)) {
                return enums;
            }
        }
        return null;
    }
}
