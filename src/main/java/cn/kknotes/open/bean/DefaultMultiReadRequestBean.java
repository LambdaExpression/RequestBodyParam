package cn.kknotes.open.bean;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 默认的 MultiReadRequest 条件
 *
 * @author lin
 * @date 2018/11/12
 */
public class DefaultMultiReadRequestBean implements MultiReadRequestBean {

    @Override
    public boolean filter(ServletRequest request) {
        return contains(request.getContentType(), MediaType.APPLICATION_JSON_VALUE)
                && Objects.equals(HttpMethod.POST.name(), ((HttpServletRequest) request).getMethod());
    }

    private boolean contains(String str1, String str2) {
        return !StringUtils.isEmpty(str1)
                && !StringUtils.isEmpty(str2)
                && str1.contains(str2);
    }

}
