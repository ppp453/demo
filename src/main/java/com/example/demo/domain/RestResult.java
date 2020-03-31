package com.example.demo.domain;


import com.example.demo.exception.BizErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResult<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public RestResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> RestResult<T> of(T data) {
        return new RestResult<>("200","success", data);
    }

    public static <T> RestResult<T> error(BizErrorCodeEnum errorCodeEnum) {
        return new RestResult<>(errorCodeEnum.getCode(),errorCodeEnum.getDescription());
    }

    public static <T> RestResult<T> error(String code, String message) {
        return new RestResult<>(code, message);
    }
}
