package com.goransico.category.presentation

import androidx.lifecycle.ViewModel
import com.goransico.category.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryViewModel : ViewModel() {

    private val category1 = Category(1,"roman",0)
    private val category2 = Category(1,"comedy",0)
    private val listOfCategories = listOf(category1, category2)

    fun loadCategories() : Flow<CategoryState> {
        return  flow {
            while(true) {
                emit(CategoryState.Loaded(listOfCategories))
            }
        }
    }
}
