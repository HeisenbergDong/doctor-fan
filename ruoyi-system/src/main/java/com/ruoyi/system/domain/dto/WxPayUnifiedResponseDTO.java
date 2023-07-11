package com.ruoyi.system.domain.dto;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@XStreamAlias("xml")
public class WxPayUnifiedResponseDTO extends BaseWxPayResult implements Serializable {
    private static final long serialVersionUID = -3071655555520664644L;

    /**
     * 预支付交易会话标识
     */
    @XStreamAlias("prepay_id")
    private String prepayId;

    /**
     * 交易类型
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 二维码链接
     */
    @XStreamAlias("code_url")
    private String codeUrl;

    /**
     * 支付url
     */
    @XStreamAlias("mweb_url")
    private String mwebUrl;

}
