package com.yjh.study.basicSystem;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicSystemApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BasicSystemApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("系统已启动......");
    }
}
