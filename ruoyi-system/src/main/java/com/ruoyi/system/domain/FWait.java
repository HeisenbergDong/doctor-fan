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
 * 排队对象 f_wait
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FWait extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 排队id */
    @NotNull(message = "ID不能为空")
    private Long id;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    @NotBlank(message = "挂号号码不能为空")
    private String regNo;

    /** 患者id */
    @Excel(name = "患者id")
    @NotNull(message = "患者ID不能为空")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    @NotBlank(message = "患者姓名不能为空")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者排队状态0-排队中 1-进行中 2-已完成 */
    @Excel(name = "患者排队状态0-排队中 1-进行中 2-已完成")
    private String patientStatus;

    /** 进入队列时间 */
    @Excel(name = "进入队列时间", width = 30)
    private String waitTime;

    /** 诊室： */
    @Excel(name = "诊室：")
    @NotBlank(message = "诊室不能为空")
    private String room;

    /** 调整队列时间 */
    @Excel(name = "调整队列时间", width = 30)
    private String adjustTime;

    /** 调整队列的医生id */
    @Excel(name = "调整队列的医生id")
    private Long adjustDocId;

    /** 调整队列的医生姓名 */
    @Excel(name = "调整队列的医生姓名")
    private String adjustDocName;

    /** 接待医生id */
    @Excel(name = "接待医生id")
    private Long receptionDocId;

    /** 接待医生姓名 */
    @Excel(name = "接待医生姓名")
    private String receptionDocName;

    /** 指派医生id */
    @Excel(name = "指派医生id")
    private Long assignDocId;

    /** 指派医生姓名 */
    @Excel(name = "指派医生姓名")
    private String assignDocName;

    /** 指派医生遗嘱 */
    @Excel(name = "指派医生遗嘱")
    private String assignContent;

    /** 上一个队列的id */
    @Excel(name = "上一个队列的id")
    private Long parentId;

    /** 删除标志（0代表存在 */
    private String delFlag;

}
