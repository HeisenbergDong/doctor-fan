package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 *阿里提现封装参数
 */
@Data
@ToString
public class AliPayWithdrawDTO implements Serializable {
    private static final long serialVersionUID = -5015739945210551000L;

    /**
     * 商户网站唯一订单号
     */
    private String outBizNo;

    /**
     * 订单总金额，单位为元
     */
    private String transAmount;

    /**
     * 产品码: TRANS_ACCOUNT_NO_PWD
     */
    private String productCode = "TRANS_ACCOUNT_NO_PWD";

    /**
     * 业务场景。单笔无密转账固定为 DIRECT_TRANSFER
     */
    private String bizScene = "DIRECT_TRANSFER";

    /**
     * 收款方信息
     */
    private AliPayeeInfo payeeInfo;

    /**
     * 转账业务的标题，用于在支付宝用户的账单里显示。
     *
     * 示例值：201905代发
     */
    private String orderTitle;

    /**
     * 业务备注。
     *
     * 示例值：201905代发
     */
    private String remark;

    /**
     * 转账业务请求的扩展参数，支持传入的扩展参数如下：
     *
     * payer_show_name_use_alias：是否展示付款方别名，可选，收款方在支付宝账单中可见。枚举支持：
     * true：展示别名，将展示商家支付宝在商家中心 商户信息 > 商户基本信息 页面配置的 商户别名。
     * false：不展示别名。默认为 false。
     * 示例值：{\"payer_show_name_use_alias\":\"true\"}
     */
    private String businessParams;

}
