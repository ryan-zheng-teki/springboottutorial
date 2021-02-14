package com.qiusuo.webfluxtutorial.repository.impl

import com.qiusuo.webfluxtutorial.domain.Book
import com.qiusuo.webfluxtutorial.orm.mapper.BookMapper
import com.qiusuo.webfluxtutorial.repository.CustomBookRepository
import org.springframework.r2dbc.core.DatabaseClient
import reactor.core.publisher.Flux

class CustomBookRepositoryImpl(val databaseClient: DatabaseClient): CustomBookRepository {
    override fun findAllBooks(): Flux<Book> {
        val query = "SELECT isoNumber FROM book" +
                " JOIN user2book ON book.isoNumber = user2book.book_id" +
                " JOIN user on user2book.user_id = user.id";
        val bookMapper = BookMapper()
        return databaseClient.sql(query).map(bookMapper).all()
    }

    override fun findAllBooksForUser(userId: String): Flux<Book> {
        TODO("Not yet implemented")
    }
}