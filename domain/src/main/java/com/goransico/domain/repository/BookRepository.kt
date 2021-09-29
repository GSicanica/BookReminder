package com.goransico.domain.repository

import com.goransico.domain.model.Book

interface BookRepository {
    fun loadAllBooks(): List<Book?>
    fun addBook()
}