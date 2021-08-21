package com.goransico.bookreminder.list

import com.goransico.bookreminder.model.BookWithCategory

sealed class BookListViewState {
    object Loading : BookListViewState()
    data class  Error(val cause: Throwable) : BookListViewState()
    data class Loaded(val items: List<BookWithCategory>) : BookListViewState()
    object Empty : BookListViewState()
}