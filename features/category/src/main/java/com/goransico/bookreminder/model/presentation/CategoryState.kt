package com.goransico.bookreminder.model.presentation

import com.goransico.bookreminder.model.Category

sealed class CategoryState {
    object Loading : CategoryState()
    data class Loaded(val categoryList: List<Category>) : CategoryState()
    object Empty : CategoryState()
}
