package com.answer.springboot.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Answer.AI.L
 * @date 2019-04-03
 */
@SpringBootApplication
@EnableDubboConfig
@ImportResource(locations = {"classpath:spring-dubbo.xml"})
@ComponentScan("com.answer.springboot.dubbo.consumer.controller")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}