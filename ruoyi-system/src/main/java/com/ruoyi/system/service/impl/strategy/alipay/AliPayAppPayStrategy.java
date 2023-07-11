package com.ruoyi.system.service.impl.strategy.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.system.domain.dto.AliPayAppPayDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliPayAppPayStrategy implements PayStrategy<String, AliPayAppPayDTO> {

    /**
     * 支付策略抽象
     * @param
     * @return
     */
    @Override
    public String operate(AliPayAppPayDTO aliPayAppPayDTO) {
        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest(); //获得初始化的AlipayClient
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setSubject(aliPayAppPayDTO.getSubject());// 商品名称
        model.setOutTradeNo(aliPayAppPayDTO.getOutTradeNo()); // 商户订单号
        model.setTimeoutExpress("30m");//支付超时时间
        model.setTotalAmount(aliPayAppPayDTO.getTotalAmount());// 支付金额
        model.setProductCode(aliPayAppPayDTO.getProductCode());
        request.setBizModel(model);
        request.setNotifyUrl(LtAliPayConfig.getNotifyUrl());// 回调地址
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.sdkExecute(request).getBody();
            log.info("结果:"+ form);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return form;
    }
}
