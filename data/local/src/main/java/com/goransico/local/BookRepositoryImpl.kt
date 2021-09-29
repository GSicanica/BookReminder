package com.goransico.local

import com.goransico.domain.repository.BookRepository
import com.goransico.domain.model.Book
import com.goransico.local.rawdata.Books

class BookRepositoryImpl : BookRepository {

    override fun loadAllBooks(): List<Book> {
        return Books.listOfBooks
    }

    override fun addBook() {
        TODO("Not yet implemented")
    }
}