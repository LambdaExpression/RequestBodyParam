package cn.kknotes.open.config;

import cn.kknotes.open.bean.DefaultMultiReadRequestBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.kknotes.open.bean.MultiReadRequestBean;

import javax.servlet.ServletRequest;

/**
 * 设置 MultiReadRequest 配置
 *
 * @author lin
 * @date 2018/11/9
 */
@Configuration
@ConditionalOnBean(RequestBodyParamMarkerConfiguration.Marker.class)
public class MvcMultiReadRequestConfigurer {

    /**
     * 默认的 MultiReadRequestBean 启动条件
     * 使用时必须保证至少有一个 MultiReadRequestBean ，避免每个请求都被至少读取两次body
     *
     * @param request
     * @return
     */
    @Bean(name = "defaultMultiReadRequestBean")
    public MultiReadRequestBean defaultMultiReadRequestBean(ServletRequest request) {
        return new DefaultMultiReadRequestBean();
    }

}
