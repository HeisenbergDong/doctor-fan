package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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

    /** 病志编号 */
    @Excel(name = "病志编号")
    private String patientLogNo;

    /** 病志类型 */
    @Excel(name = "病志类型")
    private String patientLogType;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者出生日期 */
    @Excel(name = "患者出生日期")
    private String patientBorn;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private Long patientAge;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String patientSex;

    /** 患者身份证号 */
    @Excel(name = "患者身份证号")
    private String patientIdCard;

    /** 患者vip类型 */
    @Excel(name = "患者vip类型")
    private String patientVipType;

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

    private List<FForm> fFormList;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;
}
