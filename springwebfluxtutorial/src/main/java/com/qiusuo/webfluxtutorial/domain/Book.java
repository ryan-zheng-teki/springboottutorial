package com.qiusuo.webfluxtutorial.domain;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    private String isoNumber;
    private String title;
}
