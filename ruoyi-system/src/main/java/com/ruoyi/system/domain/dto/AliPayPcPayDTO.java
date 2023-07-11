package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AliPayPcPayDTO implements Serializable {
    private static final long serialVersionUID = -8904298101404626854L;

    /**
     * 交易流水号
     */
    private String outTradeNo;

    /**
     * 订单总金额
     */
    private Double totalAmount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 订单描述
     */
    private String body;

    /**
     * 产品码: FAST_INSTANT_TRADE_PAY
     */
    private String productCode = "FAST_INSTANT_TRADE_PAY";

}
