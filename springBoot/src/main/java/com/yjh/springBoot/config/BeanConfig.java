package com.yjh.springBoot.config;

import com.yjh.springBoot.component.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/25 16:11
 * Version: 1.0
 * Desc:
 */
@Configuration
public class BeanConfig {

    @Bean
    public A a() {
        return new A();
    }
}
