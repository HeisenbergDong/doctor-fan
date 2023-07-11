package com.ruoyi.system.domain.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XStreamAlias("xml")
public class WxPayCloseOrderDTO extends WxPayBaseDTO {
    private static final long serialVersionUID = 1506146170392800461L;

    /**
     * 商户交易订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
}
