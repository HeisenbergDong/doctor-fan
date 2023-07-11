package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class AliPayCallBackResponseDTO implements Serializable {
    private static final long serialVersionUID = 3770241402381901263L;

    /**
     * 订单创建时间
     */
    private Date gmt_create;

    /**
     * 商家支付宝账号
     */
    private String seller_email;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 商家交易流水号
     */
    private String out_trade_no;

    /**
     * 支付的id
     */
    private String buyer_id;

    /**
     * 订单金额
     */
    private Double invoice_amount;

    /**
     * 支付状态 TRADE_SUCCESS 支付成功
     */
    private String trade_status;

    /**
     * 支付的登录账号
     */
    private String buyer_logon_id;

    /**
     * 支付宝交易流水号
     */
    private String trade_no;

    /**
     * 商户的AppId
     */
    private String app_id;

    /**
     * 订单总金额
     */
    private Double total_amount;

    /**
     * 响应给支付宝的字符串
     */
    private String shouldResonse = "FAILER";

}
