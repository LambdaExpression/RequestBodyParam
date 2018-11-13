package cn.kknotes.open.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import cn.kknotes.open.annotation.RequestBodyParam;
import cn.kknotes.open.exception.MethodArgumentNotValidException;

import java.util.List;
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
        RequestBodyParam requestBodyParam = parameter.getParameterAnnotation(RequestBodyParam.class);
        String json = ((ServletWebRequest) webRequest).getRequest().getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Map<String, Object> data = JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
        });
        String name = StringUtils.isEmpty(requestBodyParam.name()) ? parameter.getParameterName() : requestBodyParam.name();
        Object param = data.get(name);
        check(parameter, param, name, requestBodyParam);
        mavContainer.addAttribute(BindingResult.MODEL_KEY_PREFIX + name, param);
        if (param instanceof Map || param instanceof List) {
            return JSON.parseObject(param.toString(), parameter.getParameterType());
        } else {
            return param;
        }
    }

    /**
     * 检查参数
     * @param parameter
     * @param param
     * @param name
     * @param requestBodyParam
     * @throws MethodArgumentNotValidException
     */
    private void check(MethodParameter parameter, Object param, String name, RequestBodyParam requestBodyParam) throws MethodArgumentNotValidException {
        if (Objects.isNull(param) && requestBodyParam.required()) {
            throw new MethodArgumentNotValidException(parameter, name + " is Null ");
        }
        if (Objects.nonNull(param) && !Objects.equals(param.getClass(), parameter.getParameterType())) {
            throw new MethodArgumentNotValidException(parameter, name + " argument type mismatch ");
        }
    }


}
