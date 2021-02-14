package com.qiusuo.webfluxtutorial.orm.mapper

import com.qiusuo.webfluxtutorial.domain.Book
import io.r2dbc.spi.Row
import io.r2dbc.spi.RowMetadata
import java.util.function.BiFunction

/*
The meta data of the class can actually be stored in cache. In runtime, we use the cache directly.
We can also reuse the spring jpa Entity annotation. Migrate the JPA schema generation functionality
to r2dbc.
 */
class BookMapper: BiFunction<Row, RowMetadata, Book> {
    override fun apply(row: Row, u: RowMetadata): Book {
        val isoNumber = row.get("isoNumber", String::class.java)
        val title = row.get("title", String::class.java)
        val book =  Book(isoNumber, title, true)
        return book
    }
}