package com.goransico.category.presentation

import com.goransico.category.model.Category

sealed class CategoryState {
    object Loading : CategoryState()
    data class Loaded(val categoryList: List<Category>) : CategoryState()
    object Empty : CategoryState()
}
