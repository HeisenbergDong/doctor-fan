package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.system.domain.dto.AliPayRefundDTO;
import com.ruoyi.system.domain.dto.AliPayRefundResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import static com.ruoyi.common.constant.pay.PayCommonConstant.AliTradeResponse.TRADE_RESPONSE_REFUND;

@Slf4j
public class AliPayRefundStrategy implements PayStrategy<AlipayTradeRefundResponse, AliPayRefundDTO> {
    /**
     * 支付策略抽象
     *
     * @param aliPayRefundDTO
     * @return
     */
    @Override
    public AlipayTradeRefundResponse operate(AliPayRefundDTO aliPayRefundDTO) {
        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest();

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(JsonUtils.jsonFormat(aliPayRefundDTO));
        AlipayTradeRefundResponse alipayTradeRefundResponse = null;
        log.info("开始支付宝退款---参数:" + JSON.toJSONString(request));
        try {
            alipayTradeRefundResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        log.info("支付宝退款结束，返回参数：" + JSON.toJSONString(alipayTradeRefundResponse));
        JSONObject refundResponse = JSON.parseObject(alipayTradeRefundResponse.getBody());
        refundResponse.getObject(TRADE_RESPONSE_REFUND, AliPayRefundResponseDTO.class);
        return alipayTradeRefundResponse;
    }
}
