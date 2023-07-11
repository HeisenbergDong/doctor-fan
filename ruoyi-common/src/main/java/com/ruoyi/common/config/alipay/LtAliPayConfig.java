package com.ruoyi.common.config.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.ruoyi.common.annotation.Must;
import com.ruoyi.common.config.RuoYiConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alipay")
public class LtAliPayConfig {

    /**
     * 应用ID,您的APPID 收款账号既是您的APPID对应支付宝账号
     */
    @Must
    private static String appId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @Must
    private static String privateKey;

    /**
     * 支付宝公钥 https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    @Must
    private static String publicKey;

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @Must
    private static String notifyUrl;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @Must
    private static String returnUrl;

    /**
     * 支付宝网关
     */
    @Must
    private static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    /**
     * 签名方式
     */
    @Must
    private static String signType = "RSA2";

    /**
     * 字符编码格式
     */
    @Must
    private static String charset = "utf-8";
    /**
     * 字符编码格式
     */
    @Must
    private static String jsonFormat = "json";

    private static String certPath;
    private static String publicCertPath;
    private static String rootCertPath;

    public static String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        LtAliPayConfig.appId = appId;
    }

    public static String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        LtAliPayConfig.privateKey = privateKey;
    }

    public static String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        LtAliPayConfig.publicKey = publicKey;
    }

    public void setNotifyUrl(String notifyUrl) {
        LtAliPayConfig.notifyUrl = notifyUrl;
    }
    public static String getNotifyUrl() {
        return RuoYiConfig.getPayCallback() + notifyUrl;
    }

    public void setReturnUrl(String returnUrl) {
        LtAliPayConfig.returnUrl = returnUrl;
    }

    public static String getReturnUrl() {
        return RuoYiConfig.getPayCallback() + returnUrl;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        LtAliPayConfig.gatewayUrl = gatewayUrl;
    }

    public static String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        LtAliPayConfig.signType = signType;
    }

    public static String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        LtAliPayConfig.charset = charset;
    }

    public static String getJsonFormat() {
        return jsonFormat;
    }

    public void setJsonFormat(String jsonFormat) {
        LtAliPayConfig.jsonFormat = jsonFormat;
    }

    public static String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        LtAliPayConfig.logPath = logPath;
    }

    public static String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        LtAliPayConfig.certPath = certPath;
    }

    public static String getPublicCertPath() {
        return publicCertPath;
    }

    public void setPublicCertPath(String publicCertPath) {
        LtAliPayConfig.publicCertPath = publicCertPath;
    }

    public static String getRootCertPath() {
        return rootCertPath;
    }

    public void setRootCertPath(String rootCertPath) {
        LtAliPayConfig.rootCertPath = rootCertPath;
    }

    /**
     * 日志存放
     */
    private static String logPath = "/tmp/";

    /**
     * 获取AlipayClient对象
     *
     * @return
     */
    public static AlipayClient getAliPayClient() {
        AlipayClient aliPayClient =
                new DefaultAlipayClient(LtAliPayConfig.getGatewayUrl(), LtAliPayConfig.getAppId(),
                        LtAliPayConfig.getPrivateKey(), LtAliPayConfig.getJsonFormat(), LtAliPayConfig.getCharset(),
                        LtAliPayConfig.getPublicKey(), LtAliPayConfig.getSignType());
        return aliPayClient;
    }

    /**
     * 获取AlipayClient对象
     *
     * @return
     */
    public static AlipayClient getCertAlipayRequest() {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setAppId(LtAliPayConfig.getAppId());
//        alipayConfig.setAlipayPublicKey(LtAliPayConfig.getPublicKey());
        alipayConfig.setAppCertPath(LtAliPayConfig.getCertPath());
        alipayConfig.setAlipayPublicCertPath(LtAliPayConfig.getPublicCertPath());
        alipayConfig.setRootCertPath(LtAliPayConfig.getRootCertPath());
        alipayConfig.setCharset(LtAliPayConfig.getCharset());
        alipayConfig.setFormat(LtAliPayConfig.getJsonFormat());
        alipayConfig.setPrivateKey(LtAliPayConfig.getPrivateKey());
        alipayConfig.setServerUrl(LtAliPayConfig.getGatewayUrl());
        alipayConfig.setSignType(LtAliPayConfig.getSignType());
        AlipayClient aliPayClient = null;
        try {
            aliPayClient = new DefaultAlipayClient(alipayConfig);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return aliPayClient;
    }
}
