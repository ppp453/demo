package com.example.demo.advice;

import com.example.demo.domain.RestResult;
import com.example.demo.exception.BaseException;
import com.example.demo.utils.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public RestResult<String> handlerException(Exception ex){
        BaseException bizException = (BaseException) ex;
        String msg = bizException.getMessage();
        String code = bizException.getErrorCode().getCode();
        RestResult<String> resp = RestResult.error(code, msg);
        log.error("code:{},msg:{}",bizException.getCode(), bizException.getMessage(), ex);
        closeResources();
        return resp;
    }

    private void closeResources(){
        LoginUtil.remove();
    }
}
