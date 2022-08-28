package com.qiusuo.webfluxtutorial.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class User {
    @Id
    private val id: Long? = null

    @OneToMany
    private val books: List<Book>? = null
}