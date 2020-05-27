package springbootcassandra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbootcassandra.domain.ServiceA;
import springbootcassandra.domain.ServiceB;

@Configuration
public class AppConfigA {

    @Bean
    public ServiceA serviceA(ServiceB serviceB) {
        return new ServiceA(serviceB);

    }
}
