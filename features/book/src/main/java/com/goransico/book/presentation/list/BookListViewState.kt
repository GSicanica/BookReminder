package com.goransico.book.presentation.list

import com.goransico.book.model.BookWithCategory
import com.goransico.domain.model.Book

sealed class BookListViewState {
    object Loading : BookListViewState()
    data class  Error(val cause: Throwable) : BookListViewState()
    data class Loaded(val items: List<Book?>) : BookListViewState()
    object Empty : BookListViewState()
}