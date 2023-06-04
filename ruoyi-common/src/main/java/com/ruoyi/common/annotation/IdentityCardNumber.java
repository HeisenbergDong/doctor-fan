package com.ruoyi.common.annotation;

import com.ruoyi.common.annotation.impl.IdentityCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * IdCardValidatorUtils
 * @author LiJing
 * @version 1.0
 * @Title: IdentityCardNumber
 * @Package com.cn.alasga.common.annotation
 * @Description: 自定义注解
 * @date 2019.2.12
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {

    String message() default "身份证号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
