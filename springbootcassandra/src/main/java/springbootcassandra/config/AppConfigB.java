package springbootcassandra.config;

import springbootcassandra.domain.ServiceA;
import springbootcassandra.domain.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigB {
    @Bean
    public ServiceB serviceB(ServiceA.DomainService domainService) {
        return new ServiceB(domainService);
    }
}
