package com.qiusuo.webfluxtutorial.orm.mapper;

import com.qiusuo.webfluxtutorial.domain.Book;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.util.function.BiFunction;

public class BookMapper implements BiFunction<Row, RowMetadata, Book> {
    public Book apply(Row row, RowMetadata u) {
        Long isoNumber = row.get("isoNumber", Long.class);
        String title = row.get("title", String.class);
        Book book = new Book(isoNumber, title);
        return book;
    }
}