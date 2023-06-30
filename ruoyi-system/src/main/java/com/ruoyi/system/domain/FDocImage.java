package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 医生签名关系对象 f_doc_image
 * 
 * @author ruoyi
 * @date 2023-06-30
 */
@Data
public class FDocImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 医生id */
    @Excel(name = "医生id")
    @NotNull(message = "医生ID不能为空")
    private Long docId;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String docName;

    /** 签名图片地址 */
    @Excel(name = "签名图片地址")
    @NotBlank(message = "签名地址不能为空")
    private String fileUrl;

    /** 删除标志（0代表存在 */
    private String delFlag;

}
