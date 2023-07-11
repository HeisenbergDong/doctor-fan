package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.service.IWxPayService;
import com.ruoyi.system.service.impl.strategy.PayContent;
import com.ruoyi.system.service.impl.strategy.wxpay.WxPayAppPayStrategy;
import com.ruoyi.system.service.impl.strategy.wxpay.WxPayH5PayStrategy;
import com.ruoyi.system.service.impl.strategy.wxpay.WxPayRefundQueryStrategy;
import com.ruoyi.system.service.impl.strategy.wxpay.WxPayRefundStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WxPayServiceImpl implements IWxPayService {

    /**
     * 微信H5支付
     * @param wxPayUnifiedDTO
     * @return
     */
    @Override
    public WxPayUnifiedResponseDTO wxPayH5Pay(WxPayUnifiedDTO wxPayUnifiedDTO) {
        PayContent<WxPayUnifiedResponseDTO, WxPayUnifiedDTO> payContent = new PayContent<>(new WxPayH5PayStrategy());
        return payContent.execute(wxPayUnifiedDTO);
    }

    /**
     * 微信H5支付
     * @param wxPayUnifiedDTO
     * @return
     */
    @Override
    public WxPayUnifiedResponseDTO wxPayAppPay(WxPayUnifiedDTO wxPayUnifiedDTO) {
        PayContent<WxPayUnifiedResponseDTO, WxPayUnifiedDTO> payContent = new PayContent<>(new WxPayAppPayStrategy());
        return payContent.execute(wxPayUnifiedDTO);
    }

    /**
     * 微信退款
     * @param wxPayRefundDTO
     * @return
     */
    @Override
    public WxPayRefundResponseDTO wxRefund(WxPayRefundDTO wxPayRefundDTO) {
        PayContent<WxPayRefundResponseDTO, WxPayRefundDTO> payContent = new PayContent<>(new WxPayRefundStrategy());
        return payContent.execute(wxPayRefundDTO);
    }

    /**
     * 微信退款查询
     * @param wxPayRefundQueryDTO
     * @return
     */
    @Override
    public WxPayRefundQueryResponseDTO wxRefundQuery(WxPayRefundQueryDTO wxPayRefundQueryDTO) {
        PayContent<WxPayRefundQueryResponseDTO, WxPayRefundQueryDTO> payContent = new PayContent<>(new WxPayRefundQueryStrategy());
        return payContent.execute(wxPayRefundQueryDTO);
    }

    /**
     * 微信支付回调
     *
     * @param params
     * @return
     */
    @Override
    public WxPayCallBackResponseDTO wxPayCallBack(String params) {
        WxPayCallBackResponseDTO wxPayCallBackResponseDTO = new WxPayCallBackResponseDTO();
        return wxPayCallBackResponseDTO;
    }
}
