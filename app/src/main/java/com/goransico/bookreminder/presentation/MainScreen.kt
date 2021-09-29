package com.goransico.bookreminder.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.systemBarsPadding
import com.goransico.book.presentation.list.BookListLoader
import com.goransico.bookreminder.MainViewModel
import com.goransico.bookreminder.R
import com.goransico.designsystem.components.AddFloatingButton
import com.goransico.designsystem.components.BookInputDialog

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
            //BookInputDialog(modifier = modifier.absolutePadding(), viewModel.bookInputDialogConfig)
            BookListLoader()
        }
    }
}