package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AliPayRefundQueryDTO implements Serializable {
    private static final long serialVersionUID = -1375222392074976879L;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 退款申请的单号
     */
    private String outRequestNo;

}
