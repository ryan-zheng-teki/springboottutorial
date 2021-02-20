package com.qiusuo.schema
import kotlinx.serialization.Serializable

@Serializable
data class Book(val isoNumber: String, val title: String)