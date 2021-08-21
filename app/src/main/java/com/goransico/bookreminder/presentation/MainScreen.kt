package com.goransico.bookreminder.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.systemBarsPadding
import com.goransico.bookreminder.MainViewModel
import com.goransico.bookreminder.R
import com.goransico.bookreminder.components.AddFloatingButton
import com.goransico.bookreminder.components.BookInputDialog
import com.goransico.bookreminder.presentation.list.BookListLoader

/**
 * Main Screen
 * @param viewModel
 */

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val modifier = Modifier.systemBarsPadding()

    BoxWithConstraints {
        val fabPosition = if (this.maxHeight > maxWidth) FabPosition.Center else FabPosition.End
        val corutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            modifier = modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {},
            floatingActionButton = {
                AddFloatingButton(
                    contentDescription = R.string.add_book,
                    onClick = {
                        viewModel::onFabClick
                    }
                )
            },
            floatingActionButtonPosition = fabPosition
        ) {
            BookInputDialog(modifier = modifier.fillMaxSize(), viewModel.bookInputDialogConfig)
           // BookListLoader()
        }
    }
}