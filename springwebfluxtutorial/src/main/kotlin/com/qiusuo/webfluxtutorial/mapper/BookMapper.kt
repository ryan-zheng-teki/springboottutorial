package com.qiusuo.webfluxtutorial.mapper

import com.qiusuo.webfluxtutorial.domain.Book
import io.r2dbc.spi.Row
import io.r2dbc.spi.RowMetadata
import java.util.function.BiFunction

class BookMapper : BiFunction<Row, RowMetadata?, Book> {
    override fun apply(row: Row, u: RowMetadata?): Book {
        val isoNumber = row.get("isoNumber", String::class.java)
        val title = row.get("title", String::class.java)
        return Book(isoNumber, title)
    }
}