package com.qiusuo.webfluxtutorial.repository;

import com.qiusuo.webfluxtutorial.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface UserRepository extends ReactiveCrudRepository<User, String>, CustomBookRepository