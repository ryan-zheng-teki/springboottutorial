package com.qiusuo.webfluxtutorial.domain

import jakarta.persistence.Column
import jakarta.persistence.Id


data class Book(@Id var isoNumber: String, @Column var title: String)