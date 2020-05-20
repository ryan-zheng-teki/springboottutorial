package springbootcassandra.domain;

public class ServiceB {
    private ServiceA.DomainService domainService;
    public ServiceB(ServiceA.DomainService domainService) {
        this.domainService = domainService;
        System.out.println("ServiceB");
    }
}
