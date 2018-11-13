package cn.kknotes.open.exception;

import org.springframework.core.MethodParameter;

/**
 * @author lin
 * @date 2018/11/10
 */
public class MethodArgumentNotValidException extends Exception {

    private final MethodParameter parameter;

    private final String errorMsg;


    /**
     * Constructor for {@link MethodArgumentNotValidException}.
     *
     * @param parameter the parameter that failed validation
     * @param errorMsg  异常信息
     */
    public MethodArgumentNotValidException(MethodParameter parameter, String errorMsg) {
        this.parameter = parameter;
        this.errorMsg = errorMsg;
    }

    /**
     * Return the method parameter that failed validation.
     */
    public MethodParameter getParameter() {
        return this.parameter;
    }

    /**
     * 返回异常信息.
     */
    public String getErrorMsg() {
        return this.errorMsg;
    }


    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder("Validation failed for argument at index ")
                .append(this.parameter.getParameterIndex()).append(" in method: ")
                .append(this.parameter.getMethod().toGenericString())
                .append(", ").append(this.errorMsg);
        return sb.toString();
    }

}
