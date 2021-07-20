package com.qiusuo.webfluxtutorial.repository.impl;

import com.qiusuo.webfluxtutorial.domain.Book;
import com.qiusuo.webfluxtutorial.orm.mapper.BookMapper;
import com.qiusuo.webfluxtutorial.repository.CustomBookRepository;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

public class CustomBookRepositoryImpl implements CustomBookRepository {
    private DatabaseClient databaseClient;

    public CustomBookRepositoryImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Flux<Book> findAllBooks() {
        String query = "SELECT isoNumber FROM book" +
                " JOIN user2book ON book.isoNumber = user2book.book_id" +
                " JOIN user on user2book.user_id = user.id";
        BookMapper bookMapper = new BookMapper()
        return databaseClient.execute(query).map(bookMapper).all();
    }

    @Override
    public Flux<Book> findAllBooksForUser(String userId) {
        //TODO("Not yet implemented")
        return Flux.empty().ofType(Book.class);
    }
}