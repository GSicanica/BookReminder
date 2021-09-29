package com.goransico.book.presentation.list

import androidx.lifecycle.ViewModel
import com.goransico.domain.usecase.book.LoadBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var books: LoadBook

    fun loadBookList(): Flow<BookListViewState> {
        return flow {
            val state = if (books.loadAllBooks().isNotEmpty()) {
                BookListViewState.Loaded(books.loadAllBooks())
            } else {
                BookListViewState.Empty
            }
            emit(state)
        }
    }
}