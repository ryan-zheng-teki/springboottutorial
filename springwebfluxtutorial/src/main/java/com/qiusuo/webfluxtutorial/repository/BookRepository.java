package com.qiusuo.webfluxtutorial.repository;

import com.qiusuo.webfluxtutorial.domain.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface BookRepository extends ReactiveCrudRepository<Book, String>, CustomBookRepository