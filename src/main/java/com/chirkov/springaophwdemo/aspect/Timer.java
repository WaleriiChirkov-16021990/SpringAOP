package com.chirkov.springaophwdemo.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Aspect
@Component
//@Retention(RetentionPolicy.RUNTIME)
public class Timer {

    @Pointcut("execution(* com.chirkov.springaophwdemo.*.*(..))")
    protected void getTimerActions() {
    }
}
