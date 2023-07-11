package com.ruoyi.system.service.impl.strategy.wxpay;

import com.github.binarywang.wxpay.util.SignUtils;
import com.ruoyi.common.config.wxpay.WxApiRequestUrlEnum;
import com.ruoyi.common.config.wxpay.WxPayConfig;
import com.ruoyi.common.utils.WxPayHttpUtils;
import com.ruoyi.common.utils.XmlUtils;
import com.ruoyi.system.domain.dto.WxPayCloseOrderDTO;
import com.ruoyi.system.domain.dto.WxPayCloseOrderResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WxPayCloseOrderStrategy implements PayStrategy<WxPayCloseOrderResponseDTO, WxPayCloseOrderDTO> {

    /**
     * 支付策略抽象
     * @param wxPayCloseOrderDTO
     * @return
     */
    @Override
    public WxPayCloseOrderResponseDTO operate(WxPayCloseOrderDTO wxPayCloseOrderDTO) {
        log.debug("微信关闭订单号：{}", wxPayCloseOrderDTO.getOutTradeNo());
        wxPayCloseOrderDTO.setAppId(WxPayConfig.getInstance().getAppId());
        wxPayCloseOrderDTO.setMchId(WxPayConfig.getInstance().getMchId());
        wxPayCloseOrderDTO.setNonceStr(wxPayCloseOrderDTO.getOutTradeNo());
        wxPayCloseOrderDTO.setSign(null);
        wxPayCloseOrderDTO.setSign(SignUtils.createSign(wxPayCloseOrderDTO, "MD5",
                WxPayConfig.getInstance().getMchKey(), new String[0]));
        String xml = XmlUtils.toXML(wxPayCloseOrderDTO);
        String responseContent = null;
        try {
            responseContent = WxPayHttpUtils.doPost(WxApiRequestUrlEnum.API_URL_CLOSE_ORDER.getUrl(), xml);
            log.debug("微信关闭订单返回参数：{}", responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WxPayCloseOrderResponseDTO.fromXML(responseContent, WxPayCloseOrderResponseDTO.class);
    }
}
