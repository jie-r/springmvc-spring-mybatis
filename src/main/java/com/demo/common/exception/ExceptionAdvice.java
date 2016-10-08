package com.demo.common.exception;

import com.demo.common.message.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 控制器增强
 * Created by jie_r on 2016/8/30.
 */
@EnableWebMvc
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        System.out.println("参数解析失败");
        return new BaseResponse(HttpStatus.BAD_REQUEST.toString(), "could_not_read_json");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        System.out.println("不支持当前请求方法");
        return new BaseResponse(HttpStatus.METHOD_NOT_ALLOWED.toString(), "request_method_not_supported");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResponse handleHttpMediaTypeNotSupportedException(Exception e) {
        System.out.println("不支持当前媒体类型");
        return new BaseResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(), "content_type_not_supported");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e) {
        System.out.println("服务运行异常");
        return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
    }
}
