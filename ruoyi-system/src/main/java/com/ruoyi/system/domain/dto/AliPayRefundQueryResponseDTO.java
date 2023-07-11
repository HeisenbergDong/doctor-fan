package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliPayRefundQueryResponseDTO implements Serializable {
    private static final long serialVersionUID = -1390465394060185007L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 提醒信息
     */
    private String msg;

    /**
     * 商户交易流水号
     */
    private String out_trade_no;

    /**
     * 订单总金额
     */
    private String total_amount;

    /**
     * 退款金额
     */
    private String refund_amount;

    /**
     * 支付宝交易流水号
     */
    private String trade_no;

    /**
     * 商户退款请求流水号
     */
    private String out_request_no;

    /**
     * 错误码
     */
    private String sub_code;

    /**
     * 错误信息
     */
    private String sub_msg;

}
