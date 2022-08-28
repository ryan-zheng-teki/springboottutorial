package com.qiusuo.webfluxtutorial.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
data class Book(@Id var id: Long, @Column var title: String)