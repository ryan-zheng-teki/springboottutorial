package com.qiusuo.webfluxtutorial.repository

import com.qiusuo.webfluxtutorial.domain.User;
import reactor.core.publisher.Flux;

public interface CustomUserRepository {
    Flux<User> findAllUsers();
}