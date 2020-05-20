package springbootcassandra.domain;

import org.springframework.stereotype.Component;

public class ServiceA {

    public ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        System.out.println("ServiceA");
        this.serviceB = serviceB;
    }

    @Component
    public static class DomainService {

        public  DomainService() {

        }
    }
}
