package com.yjh.springMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.yjh.springMVC.service")
@EnableAspectJAutoProxy
public class MySpring {


}
