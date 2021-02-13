package com.qiusuo.webfluxtutorial.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.data.domain.Persistable


class User(id: String, var name: String, isNew: Boolean): Persistable<String> {
    override fun getId(): String? {
        TODO("Not yet implemented")
    }

    override fun isNew(): Boolean {
        TODO("Not yet implemented")
    }
}