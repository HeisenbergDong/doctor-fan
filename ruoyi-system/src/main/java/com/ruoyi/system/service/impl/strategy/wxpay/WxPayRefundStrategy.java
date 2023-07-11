package com.ruoyi.system.service.impl.strategy.wxpay;

import com.github.binarywang.wxpay.util.SignUtils;
import com.ruoyi.common.config.wxpay.WxApiRequestUrlEnum;
import com.ruoyi.common.config.wxpay.WxPayConfig;
import com.ruoyi.common.utils.WxPayHttpUtils;
import com.ruoyi.common.utils.XmlUtils;
import com.ruoyi.system.domain.dto.WxPayRefundDTO;
import com.ruoyi.system.domain.dto.WxPayRefundResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class WxPayRefundStrategy implements PayStrategy<WxPayRefundResponseDTO, WxPayRefundDTO> {
    /**
     * 支付策略抽象
     *
     * @param wxPayRefundDTO
     * @return
     */
    @Override
    public WxPayRefundResponseDTO operate(WxPayRefundDTO wxPayRefundDTO) {
        log.debug("微信退款商户订单号：{},微信退款商户退款单号：{}", wxPayRefundDTO.getOutTradeNo(), wxPayRefundDTO.getOutRefundNo());
        WxPayConfig wxPayConfig = WxPayConfig.getInstance();
        wxPayRefundDTO.setAppId(wxPayConfig.getAppId());
        wxPayRefundDTO.setMchId(wxPayConfig.getMchId());
        wxPayRefundDTO.setNonceStr(wxPayRefundDTO.getOutTradeNo());
        wxPayRefundDTO.setRefundNotifyUrl(wxPayConfig.getRefundNotify());
        //微信支付提交的金额是不能带小数点的，且是以分为单位，所以我们系统如果是以元为单位要处理下金额，即先乘以100，再去小数点
        wxPayRefundDTO.setRefundFee(new BigDecimal(wxPayRefundDTO.getRefundFee()).multiply(new BigDecimal("100")).intValue() + "");
        wxPayRefundDTO.setTotalFee(new BigDecimal(wxPayRefundDTO.getTotalFee()).multiply(new BigDecimal("100")).intValue() + "");
        wxPayRefundDTO.setSign(SignUtils.createSign(wxPayRefundDTO, "MD5", wxPayConfig.getMchKey(), new String[0]));
        String xml = XmlUtils.toXML(wxPayRefundDTO);
        log.debug(xml);
        String responseContent = null;
        try {
            responseContent = WxPayHttpUtils.doRefund(WxApiRequestUrlEnum.API_URL_REFUND.getUrl(), xml);
            log.debug("微信退款申请返回参数：{}", responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WxPayRefundResponseDTO refundResponse = WxPayRefundResponseDTO.fromXML(responseContent, WxPayRefundResponseDTO.class);
        //因为微信返回的是分，这里我们将分转换成元
        if (refundResponse.getResultCode().equals("SUCCESS")) {
            refundResponse.setRefundFee(new BigDecimal(refundResponse.getRefundFee()).divide(new BigDecimal("100")).floatValue() + "");
            refundResponse.setTotalFee(new BigDecimal(refundResponse.getTotalFee()).divide(new BigDecimal("100")).floatValue() + "");
        }
        return refundResponse;
    }

}
