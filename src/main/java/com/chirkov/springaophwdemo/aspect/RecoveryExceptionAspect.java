package com.chirkov.springaophwdemo.aspect;

import com.chirkov.springaophwdemo.annotation.RecoverException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RecoveryExceptionAspect {
    @Pointcut("@annotation(recoverException)")
    public void recoverExceptionMethod(RecoverException recoverException) {

    }

    @Around("recoverExceptionMethod(recoverException)")
    public Object recoverException(ProceedingJoinPoint joinPoint, RecoverException recoverException) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            for (Class<? extends RuntimeException> exceptionClass : recoverException.noRecovery()) {
                String ex = exceptionClass.getSimpleName();
                String eThr = e.getClass().getSimpleName();
                if (ex.equals(eThr)) {
                    throw new Throwable(e);
                }
            }
            return getDefaultValueForReturnType(joinPoint);
        }
    }

    private Object getDefaultValueForReturnType(ProceedingJoinPoint joinPoint) {
        String returnType = joinPoint.getSignature().toLongString().split("\\s+")[1];
        switch (returnType) {
            case "void":
                return null;
            case "short":
            case "byte":
            case "long":
            case "int":
                return 0;
            case "boolean":
                return false;
            case "double":
            case "float":
                return 0.0;
            default:
                return null;
        }
    }
}
