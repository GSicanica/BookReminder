package com.goransico.bookreminder.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @param contentDescription string resource to describe the add button
 * @param onClick function to be called on the click
 */

@Composable
fun AddFloatingButton(@StringRes contentDescription: Int, onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick, backgroundColor = MaterialTheme.colors.primary) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = stringResource(id = contentDescription)
        )
    }
}

/**
 * BookInputDialog enter reading Book
 * @param modifier Input Dialog modifier
 * @param config Book Input Dialog Config
 */

@Composable
fun BookInputDialog(modifier: Modifier = Modifier, config: BookInputDialogConfig?) {
    if (config == null) return
    var input by rememberSaveable { mutableStateOf("") }
    AlertDialog(
        modifier = modifier,
        onDismissRequest = config.onDismiss,
        text = {
            Column {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = config.titleStringRes),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                }
                TextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                            value = input,
                    onValueChange = {
                      /*  if (isInputValid(it)) {
                            input = it
                        }*/
                    })
            }
        },
        buttons = {}
    )
}

























