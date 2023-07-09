package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 生物测量仪对象 f_form_phy
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Data
public class FFormPhy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    @NotNull(message = "患者ID不能为空")
    private Long patientId;

    /** 填单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填单日期", width = 30, dateFormat = "yyyy-MM-dd")
    @NotNull(message = "填单日期不能为空")
    private Date formTime;

    /** 右眼 */
    @Excel(name = "右眼")
    @NotNull(message = "右眼信息不能为空")
    private BigDecimal r;

    /** 左眼 */
    @Excel(name = "左眼")
    @NotNull(message = "左眼信息不能为空")
    private BigDecimal l;

    /** 删除标志（0代表存在 */
    private String delFlag;

}
