package com.qiusuo.webfluxtutorial.repository

import com.qiusuo.webfluxtutorial.domain.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository

internal interface UserRepository : ReactiveCrudRepository<User, String>, CustomBookRepository