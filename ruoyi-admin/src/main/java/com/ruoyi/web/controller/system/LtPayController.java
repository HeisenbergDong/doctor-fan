package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.Convert2Map;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.service.IAliPayService;
import com.ruoyi.system.service.IWxPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/pay")
@Slf4j
public class LtPayController extends BaseController {

    @Autowired
    private IAliPayService aliPayService;

    @Autowired
    private IWxPayService wxPayService;

    /**  ------------------------------支付宝------------------------------ */

    /**
     * 支付宝h5支付
     * @param h5PayDTO
     * @return
     */
    @PostMapping(("/ali/h5"))
    public AjaxResult aliPayH5Pay(@RequestBody AliPayH5PayDTO h5PayDTO){
        return AjaxResult.success(aliPayService.aliPayH5Pay(h5PayDTO));
    }

    /**
     * 支付宝App支付
     * @param appPayDTO
     * @return
     */
    @PostMapping(("/ali/app"))
    public AjaxResult aliPayAppPay(@RequestBody AliPayAppPayDTO appPayDTO){
        return AjaxResult.success(aliPayService.aliPayAppPay(appPayDTO));
    }

    /**
     * 支付宝提现
     * @param aliPayWithdrawDTO
     * @return
     */
    @PostMapping(("/ali/withdraw"))
    public AjaxResult aliPayWithdraw(@RequestBody AliPayWithdrawDTO aliPayWithdrawDTO){
        return AjaxResult.success(aliPayService.aliPayWithdraw(aliPayWithdrawDTO));
    }

    /**
     * 支付宝退款
     * @param refundDTO
     * @return
     */
    @PostMapping(("/ali/refund"))
    public AjaxResult aliRefund(@RequestBody AliPayRefundDTO refundDTO){
        return AjaxResult.success(aliPayService.aliRefund(refundDTO));
    }

    /**
     * 支付宝退款查询
     * @param aliPayRefundQueryDTO
     * @return
     */
    @PostMapping(("/ali/refund/query"))
    public AjaxResult refundQuery(@RequestBody AliPayRefundQueryDTO aliPayRefundQueryDTO){
        return AjaxResult.success(aliPayService.refundQuery(aliPayRefundQueryDTO));
    }

    /**
     * 支付宝回调通知-异步
     * @param request
     * @return
     */
    @PostMapping(("/ali/callback/notify"))
    public String aliPayCallBackNotify(HttpServletRequest request){
        String logPrefix = "【支付宝支付回调通知】";
        Map<String, String> params = Convert2Map.requestToMap(request);
        log.info("{}通知请求数据:reqStr={}", logPrefix, params);
        return aliPayService.aliPayCallBackNotify(params);
//        return AjaxResult.success(aliPayService.aliPayCallBackNotify(params));
    }

    /**
     * 支付宝回调通知-同步
     * @param request
     * @return
     */
    @PostMapping(("/ali/callback/sync"))
    public AjaxResult aliPayCallBackSync(HttpServletRequest request){
        String logPrefix = "【支付宝退款回调通知】";
        Map<String, String> params = Convert2Map.requestToMap(request);
        log.info("{}通知请求数据:reqStr={}", logPrefix, params);
        return AjaxResult.success(aliPayService.aliPayCallBackSync(params));
    }

    /**  ------------------------------微信------------------------------ */

    /**
     * 微信h5支付
     * @param wxPayUnifiedDTO
     * @return
     */
    @PostMapping(("/wx/h5"))
    public AjaxResult wxPayH5Pay(WxPayUnifiedDTO wxPayUnifiedDTO){
        return AjaxResult.success(wxPayService.wxPayH5Pay(wxPayUnifiedDTO));
    }

    /**
     * 微信App支付
     * @param wxPayUnifiedDTO
     * @return
     */
    @PostMapping(("/wx/app"))
    public AjaxResult wxPayAppPay(@RequestBody WxPayUnifiedDTO wxPayUnifiedDTO){
        return AjaxResult.success(wxPayService.wxPayAppPay(wxPayUnifiedDTO));
    }

    /**
     * 微信退款
     * @param wxPayRefundDTO
     * @return
     */
    @PostMapping(("/wx/refund"))
    public AjaxResult wxRefund(@RequestBody WxPayRefundDTO wxPayRefundDTO){
        return AjaxResult.success(wxPayService.wxRefund(wxPayRefundDTO));
    }

    /**
     * 微信退款查询
     * @param wxPayRefundQueryDTO
     * @return
     */
    @PostMapping(("/wx/refund/query"))
    public AjaxResult refundQuery(@RequestBody WxPayRefundQueryDTO wxPayRefundQueryDTO){
        return AjaxResult.success(wxPayService.wxRefundQuery(wxPayRefundQueryDTO));
    }

    /**
     * 微信回调通知-支付结果
     * @param request
     * @return
     */
    @PostMapping(("/wx/callback/notify"))
    public AjaxResult wxPayCallBackNotify(HttpServletRequest request){
        try {
            String logPrefix = "【微信支付回调通知】";
            String params = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            log.info("{}通知请求数据:reqStr={}", logPrefix, params);
            return AjaxResult.success(wxPayService.wxPayCallBack(params));
        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 微信回调通知-退款结果
     * @param request
     * @return
     */
    @PostMapping(("/wx/callback/refund"))
    public AjaxResult wxPayCallBackRefund(HttpServletRequest request){
        try {
            String logPrefix = "【微信退款回调通知】";
            String params = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            log.info("{}通知请求数据:reqStr={}", logPrefix, params);
            return AjaxResult.success(wxPayService.wxPayCallBack(params));
        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
