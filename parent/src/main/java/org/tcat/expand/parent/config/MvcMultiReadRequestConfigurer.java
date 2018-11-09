package org.tcat.expand.parent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.tcat.expand.parent.bean.MultiReadRequestBean;

import javax.servlet.ServletRequest;
import java.util.Objects;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
public class MvcMultiReadRequestConfigurer {

    @Bean(name = "defaultMultiReadRequestBean")
    public MultiReadRequestBean defaultMultiReadRequestBean(ServletRequest request) {
        return new MultiReadRequestBean() {
            @Override
            public boolean filter(ServletRequest request) {
                return Objects.equals(request.getContentType(), MediaType.APPLICATION_JSON_UTF8_VALUE);
            }
        };
    }

}
