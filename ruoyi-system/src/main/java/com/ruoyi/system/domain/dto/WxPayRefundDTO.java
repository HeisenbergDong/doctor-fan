package com.ruoyi.system.domain.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XStreamAlias("xml")
public class WxPayRefundDTO extends WxPayBaseDTO {
    private static final long serialVersionUID = 5310984401010592054L;

    /**
     * 商户交易订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 订单金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;

    /**
     * 退款金额
     */
    @XStreamAlias("refund_fee")
    private String refundFee;

    /**
     * 退款结果通知url
     */
    @XStreamAlias("notify_url")
    private String refundNotifyUrl;
}
