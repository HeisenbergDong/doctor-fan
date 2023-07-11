package com.ruoyi.system.domain.dto;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@XStreamAlias("xml")
public class WxPayRefundQueryResponseDTO extends BaseWxPayResult implements Serializable {
    private static final long serialVersionUID = -4845214642331637046L;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 退款金额(分)
     */
    @XStreamAlias("refund_fee")
    private String refundFee;

    /**
     * 退款笔数
     */
    @XStreamAlias("refund_count")
    private Integer refundCount;

    /**
     * 随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 现金支付金额(分)
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;


}
