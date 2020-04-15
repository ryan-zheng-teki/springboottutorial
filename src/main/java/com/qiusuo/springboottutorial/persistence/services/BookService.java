package com.qiusuo.springboottutorial.persistence.services;

import com.qiusuo.springboottutorial.persistence.cassandra.model.Book;
import com.qiusuo.springboottutorial.persistence.cassandra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
