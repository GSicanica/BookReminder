package com.goransico.domain.usecase.book

import com.goransico.domain.model.Book
import com.goransico.domain.repository.BookRepository

class LoadBook(private val bookRepository: BookRepository)  {
    fun loadAllBooks(): List<Book?> = bookRepository.loadAllBooks()
    fun addBook() {
        TODO("Not yet implemented")
    }
}