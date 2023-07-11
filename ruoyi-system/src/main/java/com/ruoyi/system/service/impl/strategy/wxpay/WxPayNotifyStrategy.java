package com.ruoyi.system.service.impl.strategy.wxpay;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.util.SignUtils;
import com.ruoyi.common.config.wxpay.WxPayConfig;
import com.ruoyi.system.domain.dto.WxPayCallBackResponseDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class WxPayNotifyStrategy implements PayStrategy<WxPayCallBackResponseDTO, HttpServletRequest> {

    /**
     * 支付策略抽象
     *
     * @param httpServletRequest
     * @return
     */
    @Override
    public WxPayCallBackResponseDTO operate(HttpServletRequest httpServletRequest) {

        String xmlData = getRequestXml(httpServletRequest);
        log.debug(xmlData);
        WxPayOrderNotifyResult wxPayOrderNotifyResult =
                WxPayOrderNotifyResult.fromXML(xmlData, WxPayOrderNotifyResult.class);
        WxPayConfig wxPayConfig = WxPayConfig.getInstance();

        WxPayCallBackResponseDTO wxPayCallBackResponse = new WxPayCallBackResponseDTO();
        wxPayCallBackResponse.setAppId(wxPayOrderNotifyResult.getAppid());
        wxPayCallBackResponse.setOutTradeNo(wxPayOrderNotifyResult.getOutTradeNo());
        wxPayCallBackResponse.setTransactionId(wxPayOrderNotifyResult.getTransactionId());
        wxPayCallBackResponse.setNonceStr(wxPayOrderNotifyResult.getNonceStr());
        wxPayCallBackResponse.setMchId(wxPayOrderNotifyResult.getMchId());
        wxPayCallBackResponse.setResultCode(wxPayOrderNotifyResult.getResultCode());
        wxPayCallBackResponse.setTotalFee(wxPayOrderNotifyResult.getTotalFee().floatValue() / 100 + "");
        wxPayCallBackResponse.setTimeEnd(wxPayOrderNotifyResult.getTimeEnd());

        boolean result = SignUtils.checkSign(wxPayOrderNotifyResult, "MD5", wxPayConfig.getMchKey());
        wxPayCallBackResponse.setSignResult(result);
        return wxPayCallBackResponse;
    }

    /**
     * 获取支付和退款回调参数
     *
     * @return
     */
    private String getRequestXml(HttpServletRequest request) {
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            return new String(outSteam.toByteArray(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
