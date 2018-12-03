package cn.kknotes.open.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import cn.kknotes.open.resolver.RequestBodyParamArgumentResolver;

import java.util.List;

/**
 * @author lin
 * @date 2018/11/9
 */
@Configuration
@ConditionalOnBean(RequestBodyParamMarkerConfiguration.Marker.class)
public class ExpandMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestBodyParamArgumentResolver());
    }

}
