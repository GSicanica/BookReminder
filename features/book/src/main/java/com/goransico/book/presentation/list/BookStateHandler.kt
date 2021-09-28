package com.goransico.book.presentation.list

import com.goransico.book.model.BookWithCategory

internal data class BookStateHandler(
    val state: BookListViewState = BookListViewState.Empty,
    val onCheckedChange: (BookWithCategory) -> Unit ={},
    val onItemCLick: (Long) -> Unit ={},
    val onAddClick: () -> Unit = {}
)

