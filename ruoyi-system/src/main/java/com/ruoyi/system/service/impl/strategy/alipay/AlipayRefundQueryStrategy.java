package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.system.domain.dto.AliPayRefundQueryDTO;
import com.ruoyi.system.domain.dto.AliPayRefundQueryResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlipayRefundQueryStrategy implements PayStrategy<AliPayRefundQueryResponseDTO, AliPayRefundQueryDTO> {
    /**
     * 支付策略抽象
     *
     * @param aliPayRefunQueryDTO
     * @return
     */
    @Override
    public AliPayRefundQueryResponseDTO operate(AliPayRefundQueryDTO aliPayRefunQueryDTO) {
        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest();
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        //如果退款的时候商户退款单号并没有填写，则默认和商户交易流水号一样
        if (aliPayRefunQueryDTO.getOutRequestNo() == null || "".equals(aliPayRefunQueryDTO.getOutRequestNo())) {
            aliPayRefunQueryDTO.setOutRequestNo(aliPayRefunQueryDTO.getOutTradeNo());
        }
        request.setBizContent(JsonUtils.jsonFormat(aliPayRefunQueryDTO));
        AlipayTradeFastpayRefundQueryResponse alipayTradeFastpayRefundQueryResponse = null;
        log.debug(JSON.toJSONString(request));
        try {
            alipayTradeFastpayRefundQueryResponse = alipayClient.execute(request);
            if (alipayTradeFastpayRefundQueryResponse.isSuccess()) {
                log.info("调用成功。");
            } else {
                log.info("调用失败，原因：{}--{}", alipayTradeFastpayRefundQueryResponse.getMsg(),
                        alipayTradeFastpayRefundQueryResponse.getSubMsg());
            }
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        log.debug(JSON.toJSONString(alipayTradeFastpayRefundQueryResponse));
        JSONObject refundResponse = JSON.parseObject(alipayTradeFastpayRefundQueryResponse.getBody());
        AliPayRefundQueryResponseDTO aliPayRefundQueryResponse = refundResponse.getObject(
                PayCommonConstant.AliTradeResponse.TRADE_RESPONSE_REFUND_QUERY, AliPayRefundQueryResponseDTO.class);
        return aliPayRefundQueryResponse;
    }
}
