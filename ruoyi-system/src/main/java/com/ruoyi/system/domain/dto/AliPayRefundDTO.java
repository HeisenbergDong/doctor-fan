package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AliPayRefundDTO implements Serializable {
    private static final long serialVersionUID = 5560100056331180687L;

    /**
     * 退款金额
     */
    private Double refundAmount;

    /**
     * 订单支付时传入的商户订单号
     */
    private String outTradeNo;

    /**
     * 退款理由
     */
    private String refundReason;

    /**
     * 退款订单号
     */
    private String outRequestNo;

}
