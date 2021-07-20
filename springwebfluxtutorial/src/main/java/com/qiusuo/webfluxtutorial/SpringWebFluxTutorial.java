package com.qiusuo.webfluxtutorial;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import reactor.tools.agent.ReactorDebugAgent;

import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
public class SpringWebFluxTutorial {
    public void SpringWebFluxTutorial() {
        log.info("instantiating bean with default constructor");
    }

    public static void main(String[] args) {
        ReactorDebugAgent.init();
        SpringApplication.run(SpringWebFluxTutorial.class, args);
    }

    /**
     * Why connectionFactory is shown as redundant
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        //initializer.setDatabaseCleaner(new ResourceDatabasePopulator(new ClassPathResource("schemaCleaner.sql")));
        return initializer;
    }

    @PreDestroy
    public void onExit() {
        log.info("###STOPing###");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("###STOP FROM THE LIFECYCLE###");
    }

}


