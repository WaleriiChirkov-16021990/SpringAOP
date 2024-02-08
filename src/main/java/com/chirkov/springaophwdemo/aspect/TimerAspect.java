package com.chirkov.springaophwdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class TimerAspect {

    /**
     * Описал пакет, в котором все классы и методы будет отслеживать мой таймер
     */
    @Pointcut("@within(com.chirkov.springaophwdemo.annotation.Timer) || @annotation(com.chirkov.springaophwdemo.annotation.Timer)")
    public void getTimerAction() {

    }

    @Around("getTimerAction()")
    public Object getTimerActions(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object action = point.proceed();
//        long end = System.currentTimeMillis();
        long workedTime = System.currentTimeMillis() - start;
//        System.out.println("start: " + start + " end: " + end);
//        System.out.println("Method : [" + point.getSignature().getName() + "], for class : " + action.getClass().getName() + "worked " + workedTime);
        log.info("className: [ " + point.getTarget().getClass().getSimpleName() + " ], Method : [ " + point.getSignature().getName() + " ] : worked [ " + workedTime + " ms ];");
        return action;
    }
}
