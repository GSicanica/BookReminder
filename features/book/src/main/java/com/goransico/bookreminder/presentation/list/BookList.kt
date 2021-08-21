package com.goransico.bookreminder.presentation.list

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.goransico.bookreminder.model.presentation.CategoryViewModel
import com.goransico.bookreminder.list.BookListViewState
import com.goransico.bookreminder.list.BookStateHandler
import com.goransico.bookreminder.model.presentation.CategoryState
import com.goransico.bookreminder.presentation.detail.CategoryId
import androidx.compose.ui.Modifier

var bookListViewModel = BookViewModel()
var categoryViewModel = CategoryViewModel()

@Composable
fun BookListLoader(modifier: Modifier = Modifier) {

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val (currentCategory, setCategory) = rememberSaveable { mutableStateOf<CategoryId?>(null) }

    val bookViewState by remember(bookListViewModel, currentCategory) {
        bookListViewModel.loadBookList(currentCategory?.value)
    }.collectAsState(initial = BookListViewState.Loading)

    val categoryViewState by remember(categoryViewModel) { categoryViewModel.loadCategories() }
        .collectAsState(initial = CategoryState.Loading)

    val bookHandler = BookStateHandler(
        state = bookViewState,
        onCheckedChange = {},
        onItemCLick = {},
        onAddClick = {}
    )

    val categoryHandler = CategoryStateHandler(
        state = categoryViewState,
        currentCategory = currentCategory,
        onCategoryChange = setCategory,
    )


    BoxWithConstraints {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            backgroundColor = MaterialTheme.colors.background
        ) {
            Crossfade(bookHandler.state) { state ->
                when (state) {
                    BookListViewState.Loading -> Text("Loading")
                    is BookListViewState.Loaded -> Text("Loaded")
                    is BookListViewState.Error -> Text("Error")
                }
            }
        }
    }
}























