package com.qiusuo.webfluxtutorial;

import com.qiusuo.webfluxtutorial.domain.Book;
import com.qiusuo.webfluxtutorial.repository.BookRepository;
import graphql.Scalars;
import graphql.schema.DataFetcher;
import graphql.schema.FieldCoordinates;
import graphql.schema.GraphQLCodeRegistry;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import reactor.core.publisher.Hooks;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class SpringWebFluxTutorial {
    private static final Logger logger = LoggerFactory.getLogger(SpringWebFluxTutorial.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxTutorial.class, args);
        Hooks.onOperatorDebug();
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        System.out.println("Going to initiate database table");
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return (args) -> {
            bookRepository.saveAll(Arrays.asList(
                    new Book("iso2343", "machine learning"),
                    new Book("iso2344", "java"),
                    new Book("iso2345", "javascript"),
                    new Book("iso2346", "typescript")))
                    .blockLast(Duration.ofSeconds(10));
            logger.info("Customers found with findAll():");
        };
    }

}


