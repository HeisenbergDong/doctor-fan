package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.*;

public interface IWxPayService {
    /**
     * 微信H5支付
     *
     * @param wxPayUnifiedDTO
     * @return
     */
    WxPayUnifiedResponseDTO wxPayH5Pay(WxPayUnifiedDTO wxPayUnifiedDTO);

    /**
     * 微信H5支付
     *
     * @param wxPayUnifiedDTO
     * @return
     */
    WxPayUnifiedResponseDTO wxPayAppPay(WxPayUnifiedDTO wxPayUnifiedDTO);

    /**
     * 微信退款
     *
     * @param wxPayRefundDTO
     * @return
     */
    WxPayRefundResponseDTO wxRefund(WxPayRefundDTO wxPayRefundDTO);

    /**
     * 微信退款查询
     *
     * @param wxPayRefundQueryDTO
     * @return
     */
    WxPayRefundQueryResponseDTO wxRefundQuery(WxPayRefundQueryDTO wxPayRefundQueryDTO);

    /**
     * 微信支付回调
     *
     * @param params
     * @return
     */
    WxPayCallBackResponseDTO wxPayCallBack(String params);

}
