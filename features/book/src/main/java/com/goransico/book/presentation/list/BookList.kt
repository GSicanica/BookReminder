package com.goransico.book.presentation.list

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.goransico.category.presentation.CategoryViewModel

var categoryViewModel = CategoryViewModel()

@Composable
fun BookListLoader(modifier: Modifier = Modifier) {

    val bookListViewModel: BookViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    //initial state loading
    val bookViewState by remember {
        bookListViewModel.loadBookList()
    }.collectAsState(initial = BookListViewState.Loading)

    val bookHandler = BookStateHandler(
            state = bookViewState,
            onCheckedChange = {},
            onItemCLick = {},
            onAddClick = {}
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
                    is BookListViewState.Loaded -> Text(state.items.last().toString())
                    is BookListViewState.Error -> Text("Error")
                }
            }
        }
    }
}























