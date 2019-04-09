package com.github.lambdaexpression.exception;

import org.springframework.core.MethodParameter;

/**
 * @author lin
 * @date 2018/11/16
 */
public class HttpMediaTypeOrHttpBodyException extends Exception {

    private final MethodParameter parameter;
    private Exception e;


    /**
     * Constructor for {@link MethodArgumentNotValidException}.
     *
     * @param parameter the parameter that failed validation
     */
    public HttpMediaTypeOrHttpBodyException(MethodParameter parameter, Exception e) {
        this.parameter = parameter;
        this.e = e;
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
                .append(", please check the cn.kknotes.open.bean.MultiReadRequestBean filter condition ( Default ContentType or HttpMethod ERROR ) \n")
                .append(e.getClass())
                .append(" : ")
                .append(e.getMessage());
        return sb.toString();
    }

}
