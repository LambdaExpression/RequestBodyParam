package cn.kknotes.open.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import cn.kknotes.open.resolver.RequestBodyParamArgumentResolver;

import java.util.List;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
public class ExpandMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestBodyParamArgumentResolver());
    }

}
