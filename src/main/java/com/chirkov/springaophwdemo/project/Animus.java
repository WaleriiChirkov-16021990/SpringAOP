package com.chirkov.springaophwdemo.project;

import com.chirkov.springaophwdemo.annotation.Timer;
import org.springframework.stereotype.Component;

@Component
@Timer
public class Animus {
//    @Timer
    public String method(String property) {
        return property.toUpperCase();
    }
//    @Timer
    public double method2(int property) {
        return Math.pow(property, 3);
    }
}
