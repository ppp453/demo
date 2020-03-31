package com.example.demo.advice;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

@ControllerAdvice(basePackages = "com.example.demo.controller")
@Slf4j
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Method method = returnType.getMethod();
        if (method == null) {
            return false;
        }
        Class<?> type = method.getReturnType();
        if (RestResult.class.equals(type)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType mediaType, Class converterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        RestResult<Object> result = RestResult.of(o);
        //如果返回值对象为String时,此处converterType为StringMessageConverter,不会进行json序列化而进行强转，导致类型转换异常
        if (o instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;
    }
}
