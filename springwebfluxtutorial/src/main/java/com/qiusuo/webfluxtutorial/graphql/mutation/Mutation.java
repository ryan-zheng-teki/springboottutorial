package com.qiusuo.webfluxtutorial.graphql.mutation;

import com.qiusuo.webfluxtutorial.domain.Book;
import com.qiusuo.webfluxtutorial.service.BookService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BookService bookService;

    public Mutation(BookService bookService) {
        this.bookService = bookService;
    }

    Mono<Book> createBook(String isoNumber, String title) {
        return this.bookService.createBook(isoNumber, title);
    }
}

