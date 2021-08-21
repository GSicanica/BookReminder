package com.goransico.bookreminder.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.goransico.bookreminder.designsystem.R

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

    var bookTitle by rememberSaveable { mutableStateOf(config.initialInput ?: "") }
    var authorName by rememberSaveable { mutableStateOf(config.initialInput ?: "") }
    var bookDescription by rememberSaveable { mutableStateOf(config.initialInput ?: "") }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = config.onDismiss,
        text = {
            Column {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = config.bookTitleStringRes),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        value = bookTitle,
                        onValueChange = {
                            bookTitle = it
                        },
                        singleLine = true,
                        textStyle = MaterialTheme.typography.h4.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(
                            autoCorrect = false,
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = config.authorNameStringRes),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start,
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        value = authorName,
                        onValueChange = {
                            authorName = it
                        },
                        singleLine = true,
                        textStyle = MaterialTheme.typography.h4.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(
                            autoCorrect = false,
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = config.bookDescription),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                }
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = bookDescription,
                    onValueChange = {
                        bookDescription = it
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.h4.copy(textAlign = TextAlign.Center),
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
            }
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                val buttonModifier = Modifier.align(Alignment.CenterVertically)
                TextButton(
                    modifier = buttonModifier,
                    onClick = config.onDismiss,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colors.onSurface
                    )
                ) {
                    Text(text = stringResource(id = R.string.cancel_button).uppercase())
                }
                TextButton(
                    modifier = buttonModifier,
                    onClick = {
                        config.onSubmitTitle(bookTitle)
                        config.onSubmitAuthorName(authorName)
                        config.onSubmitDescription(bookDescription)
                    }
                ) {
                    Text(text = stringResource(id = R.string.submit_button).uppercase())
                }
            }
        }
    )
}


























