package com.suntak.demo.handler;

import com.suntak.demo.entity.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * 当controller层发生错误时进行异常捕获抛出
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Msg exceptionHandler(HttpServletRequest req , Exception e){
            return Msg.fail().add("ErrMsg",e.getMessage());
    }

}
