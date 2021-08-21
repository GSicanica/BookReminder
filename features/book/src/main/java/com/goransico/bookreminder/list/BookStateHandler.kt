package com.goransico.bookreminder.list

import com.goransico.bookreminder.model.BookWithCategory

internal data class BookStateHandler(
    val state: BookListViewState = BookListViewState.Empty,
    val onCheckedChange: (BookWithCategory) -> Unit ={},
    val onItemCLick: (Long) -> Unit ={},
    val onAddClick: () -> Unit = {}
)

