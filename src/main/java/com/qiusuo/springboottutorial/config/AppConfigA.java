package com.qiusuo.springboottutorial.config;

import com.qiusuo.springboottutorial.domain.ServiceA;
import com.qiusuo.springboottutorial.domain.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigA {

    @Bean
    public ServiceA serviceA(ServiceB serviceB) {
        return new ServiceA(serviceB);
    }
}
