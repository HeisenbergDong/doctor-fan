package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.common.constant.pay.PayCommonConstant;
import com.ruoyi.system.domain.dto.AliPayCallBackResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AliPayCallBackStrategy implements PayStrategy<AliPayCallBackResponseDTO, Map<String, String>> {

    /**
     * 支付成功返给支付宝的值
     */
    private static final String SUCCESS = "SUCCESS";

    /**
     * 支付策略抽象
     *
     * @param params
     * @return
     */
    @Override
    public AliPayCallBackResponseDTO operate(Map<String, String> params) {
        AliPayCallBackResponseDTO response = null;
        try {
            //回调参数验签
            boolean verify_result = AlipaySignature.rsaCertCheckV1(params, LtAliPayConfig.getPublicCertPath(),
                    LtAliPayConfig.getCharset(), LtAliPayConfig.getSignType());
            String json = JSON.toJSONString(params);
            log.debug(json);
//            if (!verify_result) {
//                throw new RuntimeException("Alipay payment callback sign check failed");
//            }
            response = JSON.parseObject(json, AliPayCallBackResponseDTO.class);
            //判断订单的支付结果
            if (PayCommonConstant.AliTradeStatus.TRADE_STATUS_SUCCESS.equals(response.getTrade_status())) {
                response.setShouldResonse(SUCCESS);
            }
        } catch (AlipayApiException e) {
            log.error("调用遭遇异常，原因：" + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
