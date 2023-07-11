package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AliPayCloseOrderDTO implements Serializable {
    private static final long serialVersionUID = -7325648611738962212L;

    /**
     * 交易流水号，不可重复
     */
    private String outTradeNo;

    /**
     * 卖家端自定义的的操作员 ID
     */
    private String operatorId;
}
