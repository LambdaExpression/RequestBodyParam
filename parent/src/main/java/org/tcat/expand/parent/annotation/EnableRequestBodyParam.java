package org.tcat.expand.parent.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 启动 RequestBodyParam 标签
 *
 * @author lin
 * @date 2018/11/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Configuration
@ComponentScan(basePackages = {"org.tcat.expand.parent"})
public @interface EnableRequestBodyParam {
}
