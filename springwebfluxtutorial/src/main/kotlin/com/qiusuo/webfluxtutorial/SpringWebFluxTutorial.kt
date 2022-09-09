package com.qiusuo.webfluxtutorial

import io.r2dbc.spi.ConnectionFactory
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator
import reactor.tools.agent.ReactorDebugAgent
import javax.annotation.PreDestroy

val log: Logger = LoggerFactory.getLogger(SpringWebFluxTutorial.javaClass)


@Slf4j
@SpringBootApplication
class SpringWebFluxTutorial {

    @Bean
    fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
        //initializer.setDatabaseCleaner(new ResourceDatabasePopulator(new ClassPathResource("schemaCleaner.sql")));
        return initializer
    }

    @PreDestroy
    fun onExit() {
        log.info("###STOPing###")
        try {
            Thread.sleep((5 * 1000).toLong())
        } catch (e: InterruptedException) {
            log.error("", e)
        }
        log.info("###STOP FROM THE LIFECYCLE###")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReactorDebugAgent.init()
            SpringApplication.run(SpringWebFluxTutorial::class.java, *args)
        }
    }

    init {
        log.info("instantiating bean with default constructor")
    }
}
