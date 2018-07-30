package com.bmw.azure.jwt.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * TaskApplication [spring boot] 主方法
 *
 * 启动方式，右键->run/debug->Spring Boot App
 *https://www.jianshu.com/p/e62af4a217eb
 * @author
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.bmw.azure.jwt"})
@EnableCaching
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
