package com.goransico.book.model

data class Book(
    val id: Long = 0,
    val title: String,
    val description: String? = null
)