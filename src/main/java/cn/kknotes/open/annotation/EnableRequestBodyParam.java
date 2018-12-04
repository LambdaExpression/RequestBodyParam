package cn.kknotes.open.annotation;

import cn.kknotes.open.config.RequestBodyParamMarkerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
@Import(RequestBodyParamMarkerConfiguration.class)
public @interface EnableRequestBodyParam {
}
