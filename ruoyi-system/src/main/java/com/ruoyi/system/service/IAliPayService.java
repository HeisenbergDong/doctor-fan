package com.ruoyi.system.service;


import com.alipay.api.response.AlipayTradeRefundResponse;
import com.ruoyi.system.domain.dto.*;

import java.util.Map;

public interface IAliPayService {

    /**
     * 支付宝H5支付
     * @param h5PayDTO
     * @return
     */
    String aliPayH5Pay(AliPayH5PayDTO h5PayDTO);

    /**
     * 支付宝H5支付
     * @param appPayDTO
     * @return
     */
    String aliPayAppPay(AliPayAppPayDTO appPayDTO);

    /**
     * 支付宝提现
     * @param aliPayWithdrawDTO
     * @return
     */
    String aliPayWithdraw(AliPayWithdrawDTO aliPayWithdrawDTO);

    /**
     * 支付宝退款
     * @param refundDTO
     * @return
     */
    AlipayTradeRefundResponse aliRefund(AliPayRefundDTO refundDTO);

    /**
     * 支付宝退款查询
     * @param aliPayRefundQueryDTO
     * @return
     */
    AliPayRefundQueryResponseDTO refundQuery(AliPayRefundQueryDTO aliPayRefundQueryDTO);

    /**
     * 支付宝支付回调
     * @param params
     * @return
     */
//    AliPayCallBackResponseDTO aliPayCallBackNotify(Map<String, String> params);
    String aliPayCallBackNotify(Map<String, String> params);

    /**
     * 支付宝退款回调
     * @param params
     * @return
     */
    AliPayCallBackResponseDTO aliPayCallBackSync(Map<String, String> params);
}
