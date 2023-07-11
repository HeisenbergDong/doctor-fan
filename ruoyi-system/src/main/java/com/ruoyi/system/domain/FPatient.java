package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 患者信息对象 f_patient
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者id */
    private Long id;

    /** 病志编号 */
    @Excel(name = "病志编号")
    private String logNo;

    /** 病志类型 */
    @Excel(name = "病志类型")
    private String logType;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String phone;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    private String idCard;

    /** 首日日期 */
    @Excel(name = "首日日期")
    private String firstDate;

    /** 患者出生日期 */
    @Excel(name = "患者出生日期")
    private String born;

    @Excel(name = "患者年龄")
    private Long age;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String sex;

    /** 准者住址 */
    @Excel(name = "准者住址")
    private String address;

    /** 职业 */
    @Excel(name = "职业")
    private String career;

    /** 会员类型 */
    @Excel(name = "会员类型")
    private String vipType;

    /** 是否黑名单0-否1-是 */
    @Excel(name = "是否黑名单0-否1-是")
    private String black;

    /** 是否新患者0-否1-是 */
    @Excel(name = "是否新患者0-否1-是")
    private String newPatient;

    /** 亲属ID */
    @Excel(name = "亲属ID")
    private String releaseId;

    /** 亲属称呼 */
    @Excel(name = "亲属称呼")
    private String releaseTag;

    /** 删除标志（0代表存在 */
    private String delFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    /** 亲属信息 */
    private List<FPatient> fReleaseList;
}
