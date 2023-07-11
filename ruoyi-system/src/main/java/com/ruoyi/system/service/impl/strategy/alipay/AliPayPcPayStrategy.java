package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.system.domain.dto.AliPayPcPayDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliPayPcPayStrategy implements PayStrategy<String, AliPayPcPayDTO> {

    /**
     * 支付策略抽象
     *
     * @param aliPayPcPayDTO
     * @return
     */
    @Override
    public String operate(AliPayPcPayDTO aliPayPcPayDTO) {
        AlipayClient aliPayClient = LtAliPayConfig.getCertAlipayRequest();

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        // 官网支付固定值
        aliPayPcPayDTO.setProductCode(PayCommonConstant.AliProductCode.PRODUCT_CODE_PC);
        // 封装请求支付信息
        // AlipayTradePagePayModel model=new AlipayTradePagePayModel();
        request.setBizContent(JsonUtils.jsonFormat(aliPayPcPayDTO));
        // 设置异步通知地址
        request.setNotifyUrl(LtAliPayConfig.getNotifyUrl());
        // 设置同步地址
        request.setReturnUrl(LtAliPayConfig.getReturnUrl());
        AlipayTradePagePayResponse alipayTradePagePayResponse = null;
        String form = "";
        log.debug(JSON.toJSONString(request));
        try {
            alipayTradePagePayResponse = aliPayClient.pageExecute(request);
            if (alipayTradePagePayResponse.isSuccess()) {
                log.debug("生成请求支付宝数据,req={}", request.getBizModel());
                form = alipayTradePagePayResponse.getBody();
                log.info("调用成功,生成跳转路径：form={}", form);
            } else {
                log.info("调用失败，原因：{}--{}", alipayTradePagePayResponse.getMsg(), alipayTradePagePayResponse.getSubMsg());
            }
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        log.debug(form);
        return form;
    }
}
