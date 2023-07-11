package com.ruoyi.system.service.impl.strategy.wxpay;

import com.github.binarywang.wxpay.util.SignUtils;
import com.ruoyi.common.config.wxpay.WxApiRequestUrlEnum;
import com.ruoyi.common.config.wxpay.WxPayConfig;
import com.ruoyi.common.utils.WxPayHttpUtils;
import com.ruoyi.common.utils.XmlUtils;
import com.ruoyi.system.domain.dto.WxPayUnifiedDTO;
import com.ruoyi.system.domain.dto.WxPayUnifiedResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class WxPayH5PayStrategy implements PayStrategy<WxPayUnifiedResponseDTO, WxPayUnifiedDTO> {

    /**
     * 支付策略抽象
     *
     * @param wxPayUnifiedDTO
     * @return
     */
    @Override
    public WxPayUnifiedResponseDTO operate(WxPayUnifiedDTO wxPayUnifiedDTO) {

        WxPayConfig wxPayConfig = WxPayConfig.getInstance();
        wxPayUnifiedDTO.setAppId(wxPayConfig.getAppId());
        wxPayUnifiedDTO.setMchId(wxPayConfig.getMchId());
        wxPayUnifiedDTO.setTradeType(wxPayConfig.getTradeType());
        wxPayUnifiedDTO.setNotifyUrl(wxPayConfig.getNotifyUrl());
        String payFee = new BigDecimal(wxPayUnifiedDTO.getTotalFee()).multiply(new BigDecimal("100")).intValue() + "";
        wxPayUnifiedDTO.setTotalFee(payFee);
        wxPayUnifiedDTO.setNonceStr(wxPayUnifiedDTO.getOutTradeNo());
        wxPayUnifiedDTO.setSpbillCreateIp(wxPayUnifiedDTO.getSpbillCreateIp());
        wxPayUnifiedDTO.setSign(null);
        wxPayUnifiedDTO.setSign(SignUtils.createSign(wxPayUnifiedDTO, "MD5", wxPayConfig.getMchKey(), new String[0]));

        String xml = XmlUtils.toXML(wxPayUnifiedDTO);
        log.info("微信下单请求参数：{}", xml);
        String responseContent = null;
        try {
            responseContent = WxPayHttpUtils.doPost(WxApiRequestUrlEnum.API_URL_UNIFIED.getUrl(), xml);
            log.info("微信下单返回参数：{}", responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WxPayUnifiedResponseDTO.fromXML(responseContent, WxPayUnifiedResponseDTO.class);
    }
}
