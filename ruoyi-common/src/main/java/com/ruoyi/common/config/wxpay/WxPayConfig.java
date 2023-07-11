package com.ruoyi.common.config.wxpay;

import com.ruoyi.common.annotation.Must;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wxpay")
@Data
@ToString
public class WxPayConfig {

    private static WxPayConfig wxPayConfig = null;

    /**
     * 众号appid
     */
    @Must
    private String appId;

    /**
     * 商户id
     */
    @Must
    private String mchId;

    /**
     * 付api安全密钥
     */
    @Must
    private String mchKey;

    /**
     * 支付回调
     */
    @Must
    private String notifyUrl;

    /**
     * 支付类型
     */
    @Must
    private String tradeType = PayCommonConstant.WxTrade.TRADE_TYPE_MWEB;

    /**
     * 退款回调
     */
    private String refundNotify;

    /**
     * 证书地址
     */
    private String certPath;

    /**
     * 签名方式.
     * 有两种HMAC_SHA256 和MD5
     *
     * @see com.github.binarywang.wxpay.constant.WxPayConstants.SignType
     */
    private String signType;

    public static WxPayConfig getInstance() {
        if (wxPayConfig != null) {
            return wxPayConfig;
        }
        wxPayConfig = new WxPayConfig();
        return wxPayConfig;
    }

    public String getNotifyUrl() {
        return RuoYiConfig.getPayCallback() + notifyUrl;
    }

    public String getRefundNotify() {
        return RuoYiConfig.getPayCallback() + refundNotify;
    }
}
