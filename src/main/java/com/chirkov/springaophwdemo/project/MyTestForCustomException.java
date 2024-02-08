package com.chirkov.springaophwdemo.project;

import com.chirkov.springaophwdemo.annotation.RecoverException;
import com.chirkov.springaophwdemo.util.CustomException;
import org.springframework.stereotype.Component;

@Component
public class MyTestForCustomException {


    @RecoverException(noRecovery = {CustomException.class})
    public boolean throwEcp() throws IllegalAccessException {

//        throw new IllegalAccessException("Hello");
//        throw new RuntimeException("Hello");
        throw new CustomException("Hello");
//        return true;
    }
}
