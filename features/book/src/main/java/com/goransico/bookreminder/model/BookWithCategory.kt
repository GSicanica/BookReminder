package com.goransico.bookreminder.model

data class BookWithCategory(
    val book: Book,
    val category: Category? = null
)