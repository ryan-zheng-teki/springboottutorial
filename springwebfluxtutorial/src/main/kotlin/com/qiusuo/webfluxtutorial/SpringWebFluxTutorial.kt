package com.qiusuo.webfluxtutorial

import io.r2dbc.spi.ConnectionFactory
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator
import reactor.tools.agent.ReactorDebugAgent
import javax.annotation.PreDestroy

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
        SpringWebFluxTutorial.log.info("###STOPing###")
        try {
            Thread.sleep((5 * 1000).toLong())
        } catch (e: InterruptedException) {
            SpringWebFluxTutorial.log.error("", e)
        }
        SpringWebFluxTutorial.log.info("###STOP FROM THE LIFECYCLE###")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReactorDebugAgent.init()
            SpringApplication.run(SpringWebFluxTutorial::class.java, *args)
        }
    }

    init {
        SpringWebFluxTutorial.log.info("instantiating bean with default constructor")
    }
}
