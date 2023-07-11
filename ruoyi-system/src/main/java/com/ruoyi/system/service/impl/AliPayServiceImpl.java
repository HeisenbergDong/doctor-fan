package com.ruoyi.system.service.impl;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.ruoyi.system.domain.LtPayWater;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.service.IAliPayService;
import com.ruoyi.system.service.ILtPayWaterService;
import com.ruoyi.system.service.impl.strategy.PayContent;
import com.ruoyi.system.service.impl.strategy.alipay.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static com.ruoyi.common.constant.pay.PayCommonConstant.AliTradeStatus.TRADE_STATUS_SUCCESS;

@Service
@Slf4j
public class AliPayServiceImpl implements IAliPayService {

    @Autowired
    private ILtPayWaterService ltPayWaterService;

    /**
     * 支付宝H5支付
     *
     * @param aliPayH5PayDTO
     * @return
     */
    @Override
    public String aliPayH5Pay(AliPayH5PayDTO aliPayH5PayDTO) {
        PayContent<String, AliPayH5PayDTO> payContent = new PayContent<>(new AlipayH5PayStrategy());
        return payContent.execute(aliPayH5PayDTO);
    }

    /**
     * 支付宝APP支付
     *
     * @param aliPayAppPayDTO
     * @return
     */
    @Override
    public String aliPayAppPay(AliPayAppPayDTO aliPayAppPayDTO) {
        PayContent<String, AliPayAppPayDTO> payContent = new PayContent<>(new AliPayAppPayStrategy());
        return payContent.execute(aliPayAppPayDTO);
    }

    /**
     * 支付宝提现
     *
     * @param aliPayWithdrawDTO
     * @return
     */
    @Override
    public String aliPayWithdraw(AliPayWithdrawDTO aliPayWithdrawDTO) {
        PayContent<String, AliPayWithdrawDTO> payContent = new PayContent<>(new AliPayWithdrawStrategy());
        return payContent.execute(aliPayWithdrawDTO);
    }

    /**
     * 支付宝退款
     *
     * @param aliPayRefundDTO
     * @return
     */
    @Override
    public AlipayTradeRefundResponse aliRefund(AliPayRefundDTO aliPayRefundDTO) {
        PayContent<AlipayTradeRefundResponse, AliPayRefundDTO> payContent = new PayContent<>(new AliPayRefundStrategy());
        return payContent.execute(aliPayRefundDTO);
    }

    /**
     * 支付宝退款查询
     *
     * @param aliPayRefundQueryDTO
     * @return
     */
    @Override
    public AliPayRefundQueryResponseDTO refundQuery(AliPayRefundQueryDTO aliPayRefundQueryDTO) {
        PayContent<AliPayRefundQueryResponseDTO, AliPayRefundQueryDTO> payContent =
                new PayContent<>(new AlipayRefundQueryStrategy());
        return payContent.execute(aliPayRefundQueryDTO);
    }

    /**
     * 支付宝回调异步
     *
     * @param params
     * @return
     */
    @Transactional
    @Override
    public String aliPayCallBackNotify(Map<String, String> params) {
        try{
            PayContent<AliPayCallBackResponseDTO, Map<String, String>> payContent = new PayContent<>(new AliPayCallBackStrategy());
            AliPayCallBackResponseDTO aliPayCallBackResponse = payContent.execute(params);
            log.info(aliPayCallBackResponse.getOut_trade_no() + "-----" + aliPayCallBackResponse.getTrade_status());
            if(TRADE_STATUS_SUCCESS.equals(aliPayCallBackResponse.getTrade_status())) {
                /** 支付成功后做业务处理 */
                if(aliPayCallBackResponse.getSubject().equals("充值")){
                    /** 记录支付流水 */
                    LtPayWater ltPayWater = new LtPayWater();
                    ltPayWaterService.callbackLtPayWater(ltPayWater);
                }
            }else{
                /** 支付失败后做业务处理 */
            }
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }

    /**
     * 支付宝回调同步
     *
     * @param params
     * @return
     */
    @Override
    public AliPayCallBackResponseDTO aliPayCallBackSync(Map<String, String> params) {
        PayContent<AliPayCallBackResponseDTO, Map<String, String>> payContent = new PayContent<>(new AliPayCallBackStrategy());
        AliPayCallBackResponseDTO aliPayCallBackResponse = payContent.execute(params);
        log.info(aliPayCallBackResponse.getOut_trade_no() + "-----" + aliPayCallBackResponse.getTrade_status());
        return aliPayCallBackResponse;
    }
}
