package com.github.lambdaexpression.demo.config;

import com.github.lambdaexpression.annotation.EnableRequestBodyParam;
import org.springframework.stereotype.Component;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
@EnableRequestBodyParam
public class RequestBodyParamConfigurer {

//    /**
//     * Customize MultiReadHttpServletRequest
//     * <p>Use default MultiReadRequestBean when don't has Customize MultiReadRequestBean
//     *
//     * 自定义 MultiReadHttpServletRequest 的使用条件
//     * <p>没有定义 MultiReadRequestBean 时，会使用默认的 MultiReadRequestBean 条件
//     *
//     * @see cn.kknotes.open.bean.DefaultMultiReadRequestBean
//     * @param request
//     * @return
//     */
//    @Bean
//    public MultiReadRequestBean testMultiReadRequestBean(ServletRequest request) {
//        return new MultiReadRequestBean() {
//            @Override
//            public boolean filter(ServletRequest request) {
//                // Definition rule
//                // 自定义条件
//                return true;
//            }
//        };
//    }

}
