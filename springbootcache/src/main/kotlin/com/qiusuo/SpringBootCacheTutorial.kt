package com.qiusuo

import net.sf.ehcache.Cache
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean


@SpringBootApplication
class SpringBootCacheTutorial {
	@Bean
	fun commandLineRunner(ctx: ApplicationContext?): CommandLineRunner? {
		return CommandLineRunner { args: Array<String> ->
			//This will hit the database
			System.out.println(employeeManager.getEmployeeById(1L))

			//This will hit the cache - verify the message in console output
			System.out.println(employeeManager.getEmployeeById(1L))

			//Access cache instance by name
			val cache: Cache = cacheManager.getCache("employeeCache")

			//Add entry to cache
			cache.put(3L, "Hello")

			//Get entry from cache
			System.out.println(cache.get(3L).get())
		}
	}
}