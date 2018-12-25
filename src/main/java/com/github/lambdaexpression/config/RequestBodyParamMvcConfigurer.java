package com.github.lambdaexpression.config;

import com.github.lambdaexpression.resolver.RequestBodyParamArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author lin
 * @date 2018/12/24
 */
@Configuration
@Import(MvcMultiReadRequestConfigurer.class)
public class RequestBodyParamMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestBodyParamArgumentResolver());
    }

}
