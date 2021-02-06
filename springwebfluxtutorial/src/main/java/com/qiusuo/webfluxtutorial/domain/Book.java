package com.qiusuo.webfluxtutorial.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String isoNumber;
    private String title;
}
