package cn.kknotes.open.demo.config;

import cn.kknotes.open.bean.MultiReadRequestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import cn.kknotes.open.annotation.EnableRequestBodyParam;

import javax.servlet.ServletRequest;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
@EnableRequestBodyParam
public class RequestBodyParamConfigurer {

    /**
     * Customize MultiReadHttpServletRequest
     * <p>Use default MultiReadRequestBean when don't has Customize MultiReadRequestBean
     *
     * 自定义 MultiReadHttpServletRequest 的使用条件
     * <p>没有定义 MultiReadRequestBean 时，会使用默认的 MultiReadRequestBean 条件
     *
     * @see cn.kknotes.open.bean.DefaultMultiReadRequestBean
     * @param request
     * @return
     */
    @Bean
    public MultiReadRequestBean testMultiReadRequestBean(ServletRequest request) {
        return new MultiReadRequestBean() {
            @Override
            public boolean filter(ServletRequest request) {
                //自定义条件
                return true;
            }
        };
    }

}
