package com.chirkov.springaophwdemo;

import com.chirkov.springaophwdemo.project.Animus;
import com.chirkov.springaophwdemo.project.MyTestForCustomException;
import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.net.ContentHandler;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class SpringAophwDemoApplication {

    public static void main(String[] args) throws IllegalAccessException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringAophwDemoApplication.class, args);
        Animus a = run.getBean(Animus.class);

        System.out.println(a.method(Animus.class.getName()));
        System.out.println(a.method2(334445));

        MyTestForCustomException exceptionTest = run.getBean(MyTestForCustomException.class);
        System.out.println(exceptionTest.throwEcp());
    }

}
