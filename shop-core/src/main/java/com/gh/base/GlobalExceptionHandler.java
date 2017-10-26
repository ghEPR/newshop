package com.gh.base;

import com.gh.exception.ParamException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{

    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public ResultInfo handlerParamException(ParamException pe){
        // 同步还是异步根据XMLHttpRequest
        return failure(pe.getMessage(),pe.getErrorCode());
    }

}
