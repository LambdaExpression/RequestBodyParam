package org.tcat.expand.parent.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.tcat.expand.parent.bean.MultiReadRequestBean;
import org.tcat.expand.parent.request.MultiReadHttpServletRequest;
import org.tcat.expand.parent.util.SpringBeanUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component
public class MultiReadRequestFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Map<String, MultiReadRequestBean> beans = SpringBeanUtil.getBeansOfType(MultiReadRequestBean.class);

        boolean use = !beans.isEmpty();
        for (MultiReadRequestBean value : beans.values()) {
            if (!value.filter(request)) {
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
