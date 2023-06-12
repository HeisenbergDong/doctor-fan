package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 就诊对象 f_visit
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FVisit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 诊断id */
    private Long id;

    /** 诊断医生id */
    @Excel(name = "诊断医生id")
    private Long docId;

    /** 诊断医生姓名 */
    @Excel(name = "诊断医生姓名")
    private String docName;

    /** 诊室 */
    @Excel(name = "诊室")
    private String room;

    /** 患者id */
    @Excel(name = "患者id")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者身份证号 */
    @Excel(name = "患者身份证号")
    private String patientIdCard;

    /** 是否新患者 */
    @Excel(name = "是否新患者")
    private String newPatient;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    private String regNo;

    /** 就诊时间 */
    @Excel(name = "就诊时间")
    private String visitTime;

    /** 删除标志（0代表存在 */
    private String delFlag;
}
