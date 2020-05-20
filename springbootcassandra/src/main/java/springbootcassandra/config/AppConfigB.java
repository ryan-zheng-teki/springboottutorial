package springbootcassandra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootcassandra.domain.ServiceA;
import springbootcassandra.domain.ServiceB;

@Configuration
public class AppConfigB {
    @Bean
    public ServiceB serviceB(ServiceA.DomainService domainService) {
        return new ServiceB(domainService);
    }
}
