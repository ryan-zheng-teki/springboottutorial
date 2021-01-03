package com.qiusuo.webfluxtutorial.domain;


import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String isoNumber;
    private String title;
}
