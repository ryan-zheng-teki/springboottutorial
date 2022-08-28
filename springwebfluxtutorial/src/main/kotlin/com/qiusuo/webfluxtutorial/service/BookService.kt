package com.qiusuo.webfluxtutorial.service

import com.qiusuo.webfluxtutorial.domain.Book
import com.qiusuo.webfluxtutorial.repository.BookRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookService(private val bookRepository: BookRepository) {
    fun createBook(isoNumber: String?, title: String?): Mono<Book> {
        val book = Book(isoNumber,
            title!!, true
        )
        return bookRepository.save(book)
    }

    fun findAll(): Flux<Book> {
        return bookRepository.findAll()
    }
}