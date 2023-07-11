package com.ruoyi.common.config.wxpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WxApiRequestUrlEnum {

    /**
     * 统一下单
     */
//    API_URL_UNIFIED("https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder", "统一下单"),
    API_URL_UNIFIED("https://api.mch.weixin.qq.com/pay/unifiedorder", "统一下单"),
    /**
     * 查询订单
     */
    API_URL_ORDER_QUERY("https://api.mch.weixin.qq.com/pay/orderquery", "查询订单"),
//    API_URL_ORDER_QUERY("https://api.mch.weixin.qq.com/sandboxnew/pay/orderquery", "查询订单"),
    /**
     * 退款接口
     */
    API_URL_REFUND("https://api.mch.weixin.qq.com/secapi/pay/refund", "申请退款"),
//    API_URL_REFUND("https://api.mch.weixin.qq.com/sandboxnew/secapi/pay/refund", "申请退款"),
    /**
     * 退款查询
     */
    API_URL_REFUND_QUERY("https://api.mch.weixin.qq.com/pay/refundquery", "查询退款"),
//    API_URL_REFUND_QUERY("https://api.mch.weixin.qq.com/sandboxnew/pay/refundquery", "查询退款"),
    /**
     * 关闭订单
     */
    API_URL_CLOSE_ORDER("https://api.mch.weixin.qq.com/pay/closeorder", "关闭订单"),
//    API_URL_CLOSE_ORDER("https://api.mch.weixin.qq.com/sandboxnew/pay/closeorder", "关闭订单"),
    /**
     * 沙箱环境获取密钥
     */
    SAND_BOX_GET_KEY("https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey","沙箱密钥");

    private String url;
    private String name;


}
