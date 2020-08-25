package com.leehikuan.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootstudyApplication.class, args);
    }

}
