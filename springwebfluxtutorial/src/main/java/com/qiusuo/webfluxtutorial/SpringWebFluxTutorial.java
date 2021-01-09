package com.qiusuo.webfluxtutorial;

import graphql.Scalars;
import graphql.schema.DataFetcher;
import graphql.schema.FieldCoordinates;
import graphql.schema.GraphQLCodeRegistry;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebFluxTutorial {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxTutorial.class, args);
    }
}


