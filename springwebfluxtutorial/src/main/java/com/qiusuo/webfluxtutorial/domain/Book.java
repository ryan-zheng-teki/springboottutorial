package com.qiusuo.webfluxtutorial.domain;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;


@AllArgsConstructor
@RequiredArgsConstructor
public class Book implements Persistable<String> {
    @Id
    private String isoNumber;
    private String title;

    @Transient
    private boolean newBook;

    @Override
    public String getId() {
        return isoNumber;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.newBook;
    }
}
