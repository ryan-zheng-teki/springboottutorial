package com.qiusuo.webfluxtutorial.controller;

import com.qiusuo.webfluxtutorial.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class PostsController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/helloworld")
    public Mono<String> getPostTitle() {
        return Mono.just("helloworld");
    }
}
