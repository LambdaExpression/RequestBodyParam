package cn.kknotes.open.bean;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 默认的 MultiReadRequest 条件
 * @author lin
 * @date 2018/11/12
 */
public class DefaultMultiReadRequestBean implements MultiReadRequestBean {

    @Override
    public boolean filter(ServletRequest request) {
        return Objects.equals(request.getContentType(), MediaType.APPLICATION_JSON_UTF8_VALUE)
                && Objects.equals(HttpMethod.POST.name(), ((HttpServletRequest) request).getMethod());
    }

}
