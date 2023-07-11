package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付流水对象 lt_pay_water
 * 
 * @author ruoyi
 * @date 2022-03-14
 */
@Data
public class LtPayWater extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long orderId;

    /** 0-微信1-支付宝 */
    @Excel(name = "0-微信1-支付宝")
    private String payType;

    /** 支付人 */
    @Excel(name = "支付人")
    private Long userId;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private BigDecimal price;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 三方支付编码 */
    @Excel(name = "三方支付编码")
    private String thirdId;

    /** 流水类型0-支付1-退款2-充值3-手续费 */
    @Excel(name = "流水类型0-支付1-退款2-充值3-手续费")
    private String waterType;

}
