package com.qiusuo.webfluxtutorial.repository

import com.qiusuo.webfluxtutorial.domain.User
import reactor.core.publisher.Flux

interface CustomUserRepository {
    fun findAllUsers(): Flux<User>
}