package org.tcat.expand.parent.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.tcat.expand.parent.annotation.RequestBodyParam;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * RequestBodyParam 参数解析器
 *
 * @author lin
 * @date 2018/11/8
 */
public class RequestBodyParamArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestBodyParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        parameter = parameter.nestedIfOptional();
        String json = ((ServletWebRequest) webRequest).getRequest().getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Map<String, Object> data = JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
        });
        String name = parameter.getParameterName();
        Object param = data.get(name);
        if (Objects.isNull(param)) {
            mavContainer.addAttribute(BindingResult.MODEL_KEY_PREFIX + name, param);
        }
        if (parameter.getParameterType() instanceof Serializable) {
            return JSON.parseObject(data.get(name).toString(), parameter.getParameterType());
        }
        return data.get(name);
    }

}
