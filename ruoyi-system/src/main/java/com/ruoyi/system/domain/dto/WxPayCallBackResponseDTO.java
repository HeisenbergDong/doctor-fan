package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class WxPayCallBackResponseDTO implements Serializable {
    private static final long serialVersionUID = 357923151140908196L;

    /**
     * 商户的订单号
     */
    private String outTradeNo;

    /**
     * 微信支付订单号
     */
    private String transactionId;

    /**
     * 支付随机字符串
     */
    private String nonceStr;

    /**
     * 公众账号ID
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 支付结果
     */
    private String resultCode;

    /**
     * 订单金额
     */
    private String totalFee;

    /**
     * 签名结果，true表示签名通过
     */
    private Boolean signResult;

    /**
     * 支付完成时间
     */
    private String timeEnd;
}
