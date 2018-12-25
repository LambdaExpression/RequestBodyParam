package com.github.lambdaexpression.exception;

import org.springframework.core.MethodParameter;

/**
 * @author lin
 * @date 2018/11/16
 */
public class HttpMediaTypeOrHttpBodyException extends Exception {

    private final MethodParameter parameter;


    /**
     * Constructor for {@link MethodArgumentNotValidException}.
     *
     * @param parameter the parameter that failed validation
     */
    public HttpMediaTypeOrHttpBodyException(MethodParameter parameter) {
        this.parameter = parameter;
    }

    /**
     * Return the method parameter that failed validation.
     */
    public MethodParameter getParameter() {
        return this.parameter;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder("Request method exception :")
                .append(this.parameter.getMethod().toGenericString())
                .append(", please check the cn.kknotes.open.bean.MultiReadRequestBean filter condition ( Default ContentType or HttpMethod ERROR ) ");
        return sb.toString();
    }

}
