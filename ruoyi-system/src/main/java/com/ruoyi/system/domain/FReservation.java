package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.IdentityCardNumber;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 预约对象 f_reservation
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FReservation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 预约id */
    private Long id;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Future(message = "预约时间不能小于当前时间")
    private Date preDate;

    /** 预约说明 */
    @Excel(name = "预约说明")
    private String preContent;

    /** 患者id */
    @Excel(name = "患者id")
    @NotNull(message = "患者id不能为空")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    @NotBlank(message = "患者姓名不能为空")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    @Pattern(regexp = "^1[3456789][0-9]{9}$",message = "手机号不符合格式")
    @NotBlank(message = "患者电话不能为空")
    private String patientPhone;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    @IdentityCardNumber(message = "身份证信息有误,请核对后提交")
    private String patientIdCard;

    /** 预约医生ID */
    @Excel(name = "预约医生ID")
    @NotNull(message = "医生Id不能为空")
    private Long docId;

    /** 预约医生姓名 */
    @Excel(name = "预约医生姓名")
    @NotBlank(message = "医生姓名不能为空")
    private String docName;

    /** 删除标志（0代表存在 */
    private String delFlag;

    private String logNo;

}
