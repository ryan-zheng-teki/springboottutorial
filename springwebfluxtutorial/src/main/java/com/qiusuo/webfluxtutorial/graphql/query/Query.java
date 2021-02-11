package com.qiusuo.webfluxtutorial.graphql.query;

import com.qiusuo.webfluxtutorial.domain.Book;
import com.qiusuo.webfluxtutorial.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class Query implements GraphQLQueryResolver {
    private BookService bookService;

    public Query(BookService bookService) {
        this.bookService = bookService;
    }

    public CompletableFuture<List<Book>> books() {
        return bookService.findAll().collectList().toFuture();
    }
}
