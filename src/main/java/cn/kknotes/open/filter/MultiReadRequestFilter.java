package cn.kknotes.open.filter;

import cn.kknotes.open.request.MultiReadHttpServletRequest;
import cn.kknotes.open.util.SpringBeanUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import cn.kknotes.open.bean.MultiReadRequestBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author lin
 * @date 2018/11/9
 */
@Component
public class MultiReadRequestFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Map<String, MultiReadRequestBean> beans = SpringBeanUtils.getBeansOfType(MultiReadRequestBean.class);

        boolean use = !beans.isEmpty();
        for (String key : beans.keySet()) {
            // 没有定义其他 MultiReadRequestBean 时，使用默认 MultiReadRequestBean 配置
            if (beans.size() > 1 && StringUtils.equals("defaultMultiReadRequestBean", key)) {
                continue;
            }
            if (!beans.get(key).filter(request)) {
                use = false;
            }
        }
        if (use) {
            MultiReadHttpServletRequest multiReadHttpServletRequest = new MultiReadHttpServletRequest(httpServletRequest);
            chain.doFilter(multiReadHttpServletRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

}
