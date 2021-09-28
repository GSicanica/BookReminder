package com.goransico.book.presentation.list

import com.goransico.category.presentation.CategoryState
import com.goransico.book.presentation.detail.CategoryId

internal data class CategoryStateHandler(
    val state: CategoryState = CategoryState.Empty,
    val currentCategory: CategoryId? = null,
    val onCategoryChange: (CategoryId?) -> Unit = {},
)
