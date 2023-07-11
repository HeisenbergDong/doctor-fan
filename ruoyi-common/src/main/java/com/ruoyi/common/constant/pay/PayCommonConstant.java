package com.ruoyi.common.constant.pay;

import java.io.File;

public class PayCommonConstant {
    /**
     * 流水状态
     */
    public static class PayStatus {
        /**
         * 支付中
         */
        public final static int PAY_STATUS_PAYING = 0;
        /**
         * 支付成功
         */
        public final static int PAY_STATUS_SUCCESS = 1;
        /**
         * 支付失败
         */
        public final static int PAY_STATUS_FAILED = 2;
        /**
         * 积分冻结
         */
        public final static int PAY_STATUS_FREEZE = 3;
        /**
         * 积分解冻
         */
        public final static int PAY_STATUS_UNFREEZE = 4;
        /**
         * 订单过期
         */
        public final static int PAY_STATUS_EXPIRED = 5;

        /**
         * 订单取消
         */
        public final static int PAY_STATUS_CANCEL = 6;
    }

    /**
     * 微信支付方式
     */
    public static class WxPayChannel {

        /**
         * 微信公众号支付
         */
        public final static String PAY_CHANNEL_WX_JSAPI = "WX_JSAPI";
        /**
         * 微信原生扫码支付
         */
        public final static String PAY_CHANNEL_WX_NATIVE = "WX_NATIVE";
        /**
         * 微信APP支付
         */
        public final static String PAY_CHANNEL_WX_APP = "WX_APP";
        /**
         * 微信H5支付
         */
        public final static String PAY_CHANNEL_WX_MWEB = "WX_MWEB";

    }

    /**
     * 微信交易类型
     */
    public static class WxTrade {
        /**
         * APP支付
         */
        public final static String TRADE_TYPE_APP = "APP";
        /**
         * 公众号支付或小程序支付
         */
        public final static String TRADE_TYPE_JSPAI = "JSAPI";
        /**
         * 原生扫码支付
         */
        public final static String TRADE_TYPE_NATIVE = "NATIVE";
        /**
         * H5支付
         */
        public final static String TRADE_TYPE_MWEB = "MWEB";
    }

    /**
     * 支付宝支付渠道
     */
    public static class AliPayChannel {
        /**
         * 支付宝移动支付
         */
        public final static String PAY_CHANNEL_ALIPAY_MOBILE = "ALIPAY_MOBILE";
        /**
         * 支付宝PC支付
         */
        public final static String PAY_CHANNEL_ALIPAY_PC = "ALIPAY_PC";
        /**
         * 支付宝WAP支付
         */
        public final static String PAY_CHANNEL_ALIPAY_WAP = "ALIPAY_WAP";
        /**
         * 支付宝当面付之扫码支付
         */
        public final static String PAY_CHANNEL_ALIPAY_QR = "ALIPAY_QR";
    }

    /**
     * 支付宝交易类型
     */
    public static class AliProductCode {
        /**
         * APP支付
         */
        public final static String PRODUCT_CODE_APP = "QUICK_MSECURITY_PAY";
        /**
         * wap支付
         */
        public final static String PRODUCT_CODE_WAP = "QUICK_WAP_WAY";
        /**
         * 电脑网站支付
         */
        public final static String PRODUCT_CODE_PC = "FAST_INSTANT_TRADE_PAY";
        /**
         * 统一收单交易支付
         */
        public final static String PRODUCT_CODE_FACE = "FACE_TO_FACE_PAYMENT";
        /**
         * 周期扣款支付
         */
        public final static String PRODUCT_CODE_CYCLE = "CYCLE_PAY_AUTH";
    }

    /**
     * 支付宝交易状态
     */
    public static class AliTradeStatus {
        /**
         * 支付宝移动支付
         */
        public final static String CONFIG_PATH = "alipay" + File.separator + "alipay";
        /**
         * 交易创建,等待买家付款
         */
        public final static String TRADE_STATUS_WAIT = "WAIT_BUYER_PAY";
        /**
         * 交易关闭
         */
        public final static String TRADE_STATUS_CLOSED = "TRADE_CLOSED";
        /**
         * 交易成功
         */
        public final static String TRADE_STATUS_SUCCESS = "TRADE_SUCCESS";
        /**
         * 交易成功且结束
         */
        public final static String TRADE_STATUS_FINISHED = "TRADE_FINISHED";
    }

    /**
     * 支付宝响应key
     */
    public static class AliTradeResponse {
        /**
         * 交易关闭key
         */
        public final static String TRADE_RESPONSE_CLOSE = "alipay_trade_close_response";
        /**
         * 退款查询key
         */
        public final static String TRADE_RESPONSE_REFUND_QUERY = "alipay_trade_fastpay_refund_query_response";
        /**
         * 退款查询key
         */
        public final static String TRADE_RESPONSE_REFUND = "alipay_trade_refund_response";
    }

    /**
     * 货币代码
     */
    public static class CurrencyCode {
        /**
         * 人民币
         */
        public final static String CHINESE_YUAN = "CNY";
    }

    /**
     * 服务端返回map中业务数据结果对应的key名称
     */
    public static final String BIZ_RESULT_KEY = "bizResult";

    public static final String RETURN_PARAM_RETCODE = "retCode";
    public static final String RETURN_PARAM_RETMSG = "retMsg";
    public static final String RESULT_PARAM_RESCODE = "resCode";
    public static final String RESULT_PARAM_ERRCODE = "errCode";
    public static final String RESULT_PARAM_ERRMSG = "errMsg";

    public static final String RETURN_VALUE_SUCCESS = "success";
    public static final String RETURN_VALUE_FAIL = "fail";

    public static final String RETURN_ALIPAY_VALUE_SUCCESS = "success";
    public static final String RETURN_ALIPAY_VALUE_FAIL = "fail";


}
