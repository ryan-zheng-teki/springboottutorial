package com.qiusuo.webfluxtutorial.repository

import com.qiusuo.webfluxtutorial.domain.Book;
import reactor.core.publisher.Flux;

public interface CustomBookRepository {
    Flux<Book> findAllBooks();

    Flux<Book> findAllBooksForUser(String userId);
}