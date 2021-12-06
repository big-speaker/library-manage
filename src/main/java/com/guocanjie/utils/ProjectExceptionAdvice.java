package com.guocanjie.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//处理异常注解
@RestControllerAdvice
public class ProjectExceptionAdvice {

//    捕获所有异常，捕获到异常时执行下列方法
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
//        输出异常信息
        ex.printStackTrace();
//        返回给前端的对象
        return new Result(false,"服务器故障，请稍后再试");
    }
}
