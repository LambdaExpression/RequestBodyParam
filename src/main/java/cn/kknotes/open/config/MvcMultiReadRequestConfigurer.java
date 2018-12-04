package cn.kknotes.open.config;

import cn.kknotes.open.bean.DefaultMultiReadRequestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import cn.kknotes.open.bean.MultiReadRequestBean;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 设置 MultiReadRequest 配置
 *
 * @author lin
 * @date 2018/11/9
 */
@Component
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
