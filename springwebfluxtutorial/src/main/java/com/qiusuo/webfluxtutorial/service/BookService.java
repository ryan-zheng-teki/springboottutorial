package com.qiusuo.webfluxtutorial.service;

import com.qiusuo.webfluxtutorial.domain.Book;
import com.qiusuo.webfluxtutorial.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<Book> createBook(String isoNumber, String title) {
        Book book = new Book(isoNumber, title);
        return this.bookRepository.save(book);
    }
    
    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }
}
