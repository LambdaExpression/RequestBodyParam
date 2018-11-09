package org.tcat.expand.parent.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author lin
 * @date 2018/11/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Configuration
@ComponentScan("org.tcat.expand.parent.config.ExpandMvcConfigurer")
public @interface EnableRequestBodyParam {
}
