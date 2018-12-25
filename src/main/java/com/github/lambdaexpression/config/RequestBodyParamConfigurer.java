package com.github.lambdaexpression.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lin
 * @date 2018/11/9
 */
@Configuration
@Import(RequestBodyParamMvcConfigurer.class)
public class RequestBodyParamConfigurer {

}
