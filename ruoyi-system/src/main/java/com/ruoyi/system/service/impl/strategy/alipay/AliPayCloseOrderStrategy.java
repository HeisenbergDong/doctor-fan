package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.system.domain.dto.AliPayCloseOrderDTO;
import com.ruoyi.system.domain.dto.AliPayCloseOrderResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliPayCloseOrderStrategy implements PayStrategy<AliPayCloseOrderResponseDTO, AliPayCloseOrderDTO> {
    /**
     * 支付策略抽象
     * @param aliPayCloseOrderDTO
     * @return
     */
    @Override
    public AliPayCloseOrderResponseDTO operate(AliPayCloseOrderDTO aliPayCloseOrderDTO) {
        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest();
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent(JsonUtils.jsonFormat(aliPayCloseOrderDTO));
        AlipayTradeCloseResponse alipayTradeCloseResponse = null;
        AliPayCloseOrderResponseDTO aliPayCloseOrderResponse = null;
        log.debug(JSON.toJSONString(request));
        try {
            // 服务端调用
            alipayTradeCloseResponse = alipayClient.execute(request);
            if (alipayTradeCloseResponse.isSuccess()) {
                log.info("调用成功。");
                JSONObject jsonObject = JSON.parseObject(alipayTradeCloseResponse.getBody());
                aliPayCloseOrderResponse = jsonObject.getObject(PayCommonConstant.AliTradeResponse.TRADE_RESPONSE_CLOSE,
                        AliPayCloseOrderResponseDTO.class);
            } else {
                log.info("调用失败，原因：{}--{}", alipayTradeCloseResponse.getMsg(), alipayTradeCloseResponse.getSubMsg());
            }
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        log.debug(JSON.toJSONString(alipayTradeCloseResponse));
        return aliPayCloseOrderResponse;
    }
}
