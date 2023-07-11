package com.ruoyi.system.service.impl.strategy.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.ruoyi.common.config.alipay.LtAliPayConfig;
import com.ruoyi.system.domain.dto.AliPayWithdrawDTO;
import com.ruoyi.system.service.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliPayWithdrawStrategy implements PayStrategy<String, AliPayWithdrawDTO> {

    /**
     * 支付策略抽象
     * @param
     * @return
     */
    @Override
    public String operate(AliPayWithdrawDTO aliPayWithdrawDTO) {

        AlipayClient alipayClient = LtAliPayConfig.getCertAlipayRequest();//获得初始化的AlipayClient
        AlipayFundTransUniTransferRequest  request = new AlipayFundTransUniTransferRequest();
        JSONObject bizContent = new JSONObject();
        JSONObject payeeInfo = new JSONObject();
        payeeInfo.put("identity_type",aliPayWithdrawDTO.getPayeeInfo().getIdentityType());
        payeeInfo.put("identity",aliPayWithdrawDTO.getPayeeInfo().getIdentity());
        payeeInfo.put("name",aliPayWithdrawDTO.getPayeeInfo().getName());
        bizContent.put("out_biz_no", aliPayWithdrawDTO.getOutBizNo());
        bizContent.put("trans_amount", aliPayWithdrawDTO.getTransAmount());
        bizContent.put("product_code", aliPayWithdrawDTO.getProductCode());
        bizContent.put("biz_scene", aliPayWithdrawDTO.getBizScene());
        bizContent.put("payee_info", payeeInfo.toString());
        bizContent.put("order_title", aliPayWithdrawDTO.getOrderTitle());
        bizContent.put("remark", aliPayWithdrawDTO.getRemark());
        request.setBizContent(bizContent.toString());
        request.setNotifyUrl(LtAliPayConfig.getNotifyUrl());// 回调地址
        String form = "";
        try {
            // 调用SDK生成表单
            AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
            if(response.isSuccess()){
                log.info("结果:成功");
            } else {
                log.info("结果:失败");
            }
            form = response.getCode();
        } catch (Exception e) {
            log.error(e.toString());
        }
        return form;
    }
}
