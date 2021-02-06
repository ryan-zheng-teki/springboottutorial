package com.qiusuo.webfluxtutorial.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
public class R2DBCConfig extends AbstractR2dbcConfiguration {
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = ConnectionFactories
                .get("r2dbc:postgresql://localhost:5432/qiusuo");
        return connectionFactory;
    }
    /*
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("localhost")
                        .port(5432)
                        .username("qiusuo")
                        .database("qiusuo")
                        .password("qiusuo")
                        .build());
    }
    */
}
