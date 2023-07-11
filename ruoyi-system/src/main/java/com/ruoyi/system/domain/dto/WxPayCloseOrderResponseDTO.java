package com.ruoyi.system.domain.dto;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxPayCloseOrderResponseDTO extends BaseWxPayResult implements Serializable {

}
