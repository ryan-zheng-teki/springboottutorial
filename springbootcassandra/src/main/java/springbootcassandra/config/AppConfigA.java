package springbootcassandra.config;

import springbootcassandra.domain.ServiceA;
import springbootcassandra.domain.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigA {

    @Bean
    public ServiceA serviceA(ServiceB serviceB) {
        return new ServiceA(serviceB);
    }
}
