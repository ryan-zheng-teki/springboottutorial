package com.qiusuo.webfluxtutorial.domain

import org.springframework.data.domain.Persistable

class Book(var isoNumber: String, var title: String, private var isNew: Boolean): Persistable<String> {
    override fun getId(): String = isoNumber

    override fun isNew(): Boolean = isNew
}