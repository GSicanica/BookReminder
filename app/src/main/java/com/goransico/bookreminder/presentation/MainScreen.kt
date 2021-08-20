package com.goransico.bookreminder.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.goransico.bookreminder.MainViewModel
import com.goransico.bookreminder.R
import com.goransico.bookreminder.components.AddFloatingButton

/**
 * Main Screen
 * @param viewModel
 */

@Composable
fun MainScreen(viewModel: MainViewModel) {

    Log.d("MainScreen", "lofg")

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
                    onClick = {}
                )
            },
            floatingActionButtonPosition = fabPosition
        ) {

            Text(text = "test")
        }
    }
}