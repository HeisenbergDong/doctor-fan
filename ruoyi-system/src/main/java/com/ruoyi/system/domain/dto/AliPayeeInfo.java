package com.ruoyi.system.domain.dto;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 阿里提现收款方用户信息
 */
@Data
@ToString
public class AliPayeeInfo implements Serializable {
    private static final long serialVersionUID = -9115739945210551000L;

    /**
     * 参与方的标识类型，目前支持如下类型：
     * 1、ALIPAY_USER_ID 支付宝的会员ID
     * 2、ALIPAY_LOGON_ID：支付宝登录号，支持邮箱和手机号格式
     */
    private String identityType = "ALIPAY_LOGON_ID";

    /**
     *
     * 参与方的标识 ID。
     *
     * 当 identity_type=ALIPAY_USER_ID 时，填写支付宝用户 UID。示例值：2088123412341234。
     * 当 identity_type=ALIPAY_LOGON_ID 时，填写支付宝登录号。示例值：186xxxxxxxx。
     */
    private String identity;

    /**
     * 参与方真实姓名。如果非空，将校验收款支付宝账号姓名一致性。
     *
     * 当 identity_type=ALIPAY_LOGON_ID 时，本字段必填。若传入该属性，则在支付宝回单中将会显示这个属性。
     */
    private String name;
}
