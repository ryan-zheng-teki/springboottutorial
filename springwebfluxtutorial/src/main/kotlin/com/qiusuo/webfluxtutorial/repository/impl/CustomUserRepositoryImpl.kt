package com.qiusuo.webfluxtutorial.repository.impl

import com.qiusuo.webfluxtutorial.domain.User
import com.qiusuo.webfluxtutorial.repository.CustomUserRepository
import org.springframework.r2dbc.core.DatabaseClient
import reactor.core.publisher.Flux

class CustomUserRepositoryImpl(private val databaseClient: DatabaseClient) : CustomUserRepository {
    override fun findAllUsers(): Flux<User> {
        return Flux.empty<Any>().ofType(User::class.java)
    }
}