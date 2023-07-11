package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.system.domain.dto.AliPayH5PayDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlipayH5PayStrategy implements PayStrategy<String, AliPayH5PayDTO> {

    /**
     * 支付策略抽象
     *
     * @param aliPay5PayDTO
     * @return
     */
    @Override
    public String operate(AliPayH5PayDTO aliPay5PayDTO) {
        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        // 官网支付固定值
        aliPay5PayDTO.setProductCode(PayCommonConstant.AliProductCode.PRODUCT_CODE_WAP);
        request.setBizContent(JsonUtils.jsonFormat(aliPay5PayDTO));
        // 设置异步通知地址
        request.setNotifyUrl(LtAliPayConfig.getNotifyUrl());
        // 设置同步地址
        request.setReturnUrl(LtAliPayConfig.getReturnUrl());
        AlipayTradeWapPayResponse alipayTradeWapPayResponse = null;
        String form = "";
        log.info(JSON.toJSONString(request));
        try {
            //主要是pc、web端使用
            alipayTradeWapPayResponse = alipayClient.pageExecute(request);
            if (alipayTradeWapPayResponse.isSuccess()) {
                log.info("生成请求支付宝数据,req={}", request.getBizModel());
                form = alipayTradeWapPayResponse.getBody();
                log.info("调用成功,生成跳转路径：form={}", form);
            } else {
                log.info("调用失败，原因：{}--{}", alipayTradeWapPayResponse.getMsg(), alipayTradeWapPayResponse.getSubMsg());
                //跑自定义异常
            }
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        log.debug(JSON.toJSONString(alipayTradeWapPayResponse));
        return form;
    }
}
