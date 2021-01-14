package com.qiusuo.webfluxtutorial.domain;


import org.springframework.data.annotation.Id;

public class Book {
    public Book(String isoNumber, String title) {
        this.isoNumber = isoNumber;
        this.title = title;
    }

    @Id
    private String isoNumber;
    private String title;
}
