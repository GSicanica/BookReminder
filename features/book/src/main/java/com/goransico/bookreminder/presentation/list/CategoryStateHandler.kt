package com.goransico.bookreminder.presentation.list

import com.goransico.bookreminder.model.presentation.CategoryState
import com.goransico.bookreminder.presentation.detail.CategoryId

internal data class CategoryStateHandler(
    val state: CategoryState = CategoryState.Empty,
    val currentCategory: CategoryId? = null,
    val onCategoryChange: (CategoryId?) -> Unit = {},
)
