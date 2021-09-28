package com.goransico.book.presentation.list

import androidx.lifecycle.ViewModel
import com.goransico.book.model.Book
import com.goransico.book.model.BookWithCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookViewModel () : ViewModel() {

    private val book1 = BookWithCategory(Book(1,"Book", null))
    private val book2 = BookWithCategory(Book(3,"Book2", null))
    private val listOfBooks = listOf(book1, book2)

    fun loadBookList(value: Long? = null) : Flow<BookListViewState> {
        return  flow {
            while(true) {
                emit(BookListViewState.Loaded(listOfBooks))
            }
        }
    }
}