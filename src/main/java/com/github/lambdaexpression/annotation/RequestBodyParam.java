package com.github.lambdaexpression.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Body 参数 标签
 *
 * @author lin
 * @date 2018/11/8
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestBodyParam {

    /**
     * 别名为 {@link #name}.
     */
    @AliasFor("name")
    String value() default "";

    /**
     * 绑定请求参数的名称
     */
    @AliasFor("value")
    String name() default "";

    /**
     * 是否是必要的 body param 参数
     * <p>默认为 {@code true} ，参数为 NULL 时抛出异常
     * 如果允许 body param 为 NULL，请设置为 {@code false}
     */
    boolean required() default true;

}
