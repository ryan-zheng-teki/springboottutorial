package com.quisuo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
open class ConfigServer


fun main(args: Array<String>) {
    runApplication<ConfigServer>(*args)
}
