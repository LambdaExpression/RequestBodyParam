package org.tcat.expand.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tcat.expand.parent.annotation.EnableRequestBodyParam;
import org.tcat.expand.parent.bean.MultiReadRequestBean;

import javax.servlet.ServletRequest;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
@EnableRequestBodyParam
public class RequestBodyParamConfigurer {

//    /**
//     * 自定义 MultiReadHttpServletRequest 的使用条件
//     * 没有定义 MultiReadRequestBean 时，会使用默认的 MultiReadRequestBean 条件
//     * @see org.tcat.expand.parent.config.MvcMultiReadRequestConfigurer
//     * @param request
//     * @return
//     */
//    @Bean
//    public MultiReadRequestBean testMultiReadRequestBean(ServletRequest request) {
//        return new MultiReadRequestBean() {
//            @Override
//            public boolean filter(ServletRequest request) {
//                //自定义条件
//                return true;
//            }
//        };
//    }

}
