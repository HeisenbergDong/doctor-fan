package com.ruoyi.system.domain.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @version V1.0
 * @description:
 * @author: AYL
 * @date: 2020/4/30
 */
@Data
@ToString
public class WxPayBaseDTO implements Serializable {
    private static final long serialVersionUID = -7413419674091721459L;

    /**
     * 公众账号ID
     */
    @XStreamAlias("appid")
    private String appId;

    /**
     * 商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XStreamAlias("sign")
    private String sign;
}
