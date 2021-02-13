package com.qiusuo.webfluxtutorial.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.data.domain.Persistable


/*
In kotlin private var will not generate the getter and setter
 */
class User(private var id: String, var name: String,private var isNew: Boolean): Persistable<String> {
    override fun getId(): String = id
    override fun isNew(): Boolean = isNew
}