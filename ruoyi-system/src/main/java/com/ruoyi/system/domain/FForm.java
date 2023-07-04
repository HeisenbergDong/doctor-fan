package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 单对象 f_form
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Data
public class FForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 表单id */
    private Long id;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    @NotBlank(message = "挂号号码不能为空")
    private String regNo;

    /** 表单类型 */
    @Excel(name = "表单类型")
    @NotBlank(message = "表单类型不能为空")
    private String type;

    /** 患者id */
    @Excel(name = "患者id")
    @NotNull(message = "表单类型不能为空")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者证件号 */
    @Excel(name = "患者证件号")
    private String patientIdCard;

    /** 诊室 */
    @Excel(name = "诊室")
    @NotBlank(message = "诊室不能为空")
    private String room;

    /** 医生id */
    @Excel(name = "医生id")
    @NotNull(message = "医生id不能为空")
    private Long docId;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String docName;

    /** 表单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "表单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date formTime;

    /** 表单内容 */
    @Excel(name = "表单内容")
    private String formContent;

    /** 附件地址，多个用，分割 */
    @Excel(name = "附件地址，多个用，分割")
    private String fileUrl;

    /** 删除标志（0代表存在 */
    private String delFlag;
    @NotNull(message = "问诊单ID不能为空")
    private Long visitId;

}
