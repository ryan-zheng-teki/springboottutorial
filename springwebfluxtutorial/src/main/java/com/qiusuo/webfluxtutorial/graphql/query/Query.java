package com.qiusuo.webfluxtutorial.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    public String user() {
        return "hello";
    }
}
