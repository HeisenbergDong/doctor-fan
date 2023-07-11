package com.ruoyi.system.domain.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

/**
 * @version V1.0
 * @description: 微信支付页面接受
 *
 * @author: AYL
 * @date: 2020/4/30
 */

@Data
@ToString
@XStreamAlias("xml")
public class WxPayUnifiedDTO extends WxPayBaseDTO {
    private static final long serialVersionUID = 6470174545936080658L;

    /**
     *商品描述
     */
    @XStreamAlias("body")
    private String body;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 总金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;

    /**
     * 终端IP
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 异步通知地址
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;
    /**
     * 异步通知地址
     */
    @XStreamAlias("mweb_url")
    private String mwebUrl;

    /**
     * 交易类型--H5支付的交易类型为MWEB
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 该字段用于上报支付的场景信息,针对H5支付有以下三种场景,
     * IOS移动应用
     * {"h5_info": {"type":"IOS","app_name": "王者荣耀","bundle_id": "com.tencent.wzryIOS"}}
     *
     * 安卓移动应用
     * {"h5_info": {"type":"Android","app_name": "王者荣耀","package_name": "com.tencent.tmgp.sgame"}}
     *
     * WAP网站应用
     * {"h5_info": {"type":"Wap","wap_url": "https://pay.qq.com","wap_name": "腾讯充值"}}
     */
    @XStreamAlias("scene_info")
    private String sceneInfo;

}
