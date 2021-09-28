package com.goransico.book.model

import com.goransico.category.model.Category

data class BookWithCategory(
    val book: Book,
    val category: Category? = null
)