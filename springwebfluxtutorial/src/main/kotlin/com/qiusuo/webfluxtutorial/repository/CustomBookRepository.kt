package com.qiusuo.webfluxtutorial.repository

import com.qiusuo.webfluxtutorial.domain.Book
import reactor.core.publisher.Flux

interface CustomBookRepository {
    fun findAllBooks(): Flux<Book>
    fun findAllBooksForUser(userId: String): Flux<Book>
}