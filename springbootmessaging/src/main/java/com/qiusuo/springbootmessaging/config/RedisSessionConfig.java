package com.qiusuo.springbootmessaging.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.PostConstruct;

@ConditionalOnProperty(name = "spring.session.store-type", havingValue = "redis")
@EnableRedisHttpSession
public class RedisSessionConfig {

    @Value("${spring.session.store-type}")
    private String sessionStoreType;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionConfig.class);

    @PostConstruct
    public void init() {
        LOGGER.info("spring.session.store-type=none turns spring session off.");
        LOGGER.info("Redis Session Replication is turned {}.", sessionStoreType.equals("redis") ? "ON"
                : "OFF");
    }

    /*
    To Be Honest, I don't understand what the following is doing.
     */
    @Bean
    public ConfigureRedisAction configureRedisAction() {
        LOGGER.info("Preventing auto-configuration in secured environments.");
        return ConfigureRedisAction.NO_OP;
    }
}