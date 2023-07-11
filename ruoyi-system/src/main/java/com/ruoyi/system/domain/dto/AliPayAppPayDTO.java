package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 *阿里app支付封装参数
 */
@Data
@ToString
public class AliPayAppPayDTO implements Serializable {
    private static final long serialVersionUID = -5015739945210554609L;

    /**
     * 交易的具体描述信息
     */
    private String subject;

    /**
     * 商户网站唯一订单号
     */
    private String outTradeNo;

    /**
     * 订单总金额，单位为元
     */
    private String totalAmount;

    /**
     * 用户付款中途退出返回商户网站的地址
     */
    private String quitUrl;

    /**
     * 对一笔交易的具体描述信息
     */
    private String body;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易
     */
    private String timeoutExpress = "30m";

    /**
     * 产品码: QUICK_WAP_WAY
     */
    private String productCode = "QUICK_MSECURITY_PAY";

    private String responseBody;

}
