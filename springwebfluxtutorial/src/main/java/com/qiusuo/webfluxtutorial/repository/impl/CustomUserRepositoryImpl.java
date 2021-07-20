package com.qiusuo.webfluxtutorial.repository.impl

import com.qiusuo.webfluxtutorial.domain.User;
import com.qiusuo.webfluxtutorial.repository.CustomUserRepository;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

public class CustomUserRepositoryImpl implements CustomUserRepository {
    private DatabaseClient databaseClient;

    public CustomUserRepositoryImpl(DatabaseClient databaseClient) {
    }

    public Flux<User> findAllUsers() {
        return Flux.empty().ofType(User.class);
    }
}