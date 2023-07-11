package com.ruoyi.system.service.impl.strategy.wxpay;

import com.github.binarywang.wxpay.util.SignUtils;
import com.ruoyi.common.config.wxpay.WxApiRequestUrlEnum;
import com.ruoyi.common.config.wxpay.WxPayConfig;
import com.ruoyi.common.utils.WxPayHttpUtils;
import com.ruoyi.common.utils.XmlUtils;
import com.ruoyi.system.domain.dto.WxPayRefundQueryDTO;
import com.ruoyi.system.domain.dto.WxPayRefundQueryResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class WxPayRefundQueryStrategy implements PayStrategy<WxPayRefundQueryResponseDTO, WxPayRefundQueryDTO> {
    /**
     * 支付策略抽象
     *
     * @param wxPayRefundQueryDTO
     * @return
     */
    @Override
    public WxPayRefundQueryResponseDTO operate(WxPayRefundQueryDTO wxPayRefundQueryDTO) {
        log.debug("微信退款查询订单号：{}", wxPayRefundQueryDTO.getOutTradeNo());

        WxPayConfig wxPayConfig = WxPayConfig.getInstance();
        wxPayRefundQueryDTO.setAppId(wxPayConfig.getAppId());
        wxPayRefundQueryDTO.setMchId(wxPayConfig.getMchId());
        wxPayRefundQueryDTO.setNonceStr(wxPayRefundQueryDTO.getOutTradeNo());
        wxPayRefundQueryDTO.setSign(SignUtils.createSign(wxPayRefundQueryDTO, "MD5", wxPayConfig.getMchKey(),
                new String[0]));
        String xml = XmlUtils.toXML(wxPayRefundQueryDTO);
        log.info(xml);
        String responseContent = null;
        try {
            responseContent = WxPayHttpUtils.doPost(WxApiRequestUrlEnum.API_URL_REFUND_QUERY.getUrl(), xml);
            log.info("微信退款查询返回参数：{}", responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WxPayRefundQueryResponseDTO wxpayRefundQueryVO = WxPayRefundQueryResponseDTO.fromXML(responseContent,
                WxPayRefundQueryResponseDTO.class);
        if (wxpayRefundQueryVO.getResultCode().equals("SUCCESS")) {
            wxpayRefundQueryVO.setRefundFee(new BigDecimal(wxpayRefundQueryVO.getRefundFee()).divide(new BigDecimal(
                    "100")).floatValue() + "");
        }

        return wxpayRefundQueryVO;
    }
}
