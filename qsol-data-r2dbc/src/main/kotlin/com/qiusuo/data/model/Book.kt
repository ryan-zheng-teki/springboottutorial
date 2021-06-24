package com.qiusuo.data.model

import jakarta.persistence.Entity


@Entity
class Book(val isoNumber: String, val author: String)