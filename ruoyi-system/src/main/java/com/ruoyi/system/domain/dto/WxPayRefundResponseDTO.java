package com.ruoyi.system.domain.dto;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@XStreamAlias("xml")
public class WxPayRefundResponseDTO extends BaseWxPayResult implements Serializable {
    private static final long serialVersionUID = 396854131840932150L;

    /**
     * 商户交易订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 微信方交易订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户退款订单号
     */
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 微信方退款订单号
     */
    @XStreamAlias("refund_id")
    private String refundId;

    /**
     * 退款金额
     */
    @XStreamAlias("refund_fee")
    private String refundFee;

    /**
     * 订单总金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;

}
