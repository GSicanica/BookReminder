package com.goransico.bookreminder.components

import androidx.annotation.StringRes

class BookInputDialogConfig(
    @StringRes val bookTitleStringRes: Int,
    @StringRes val authorNameStringRes: Int,
    @StringRes val bookDescription: Int,
    val initialInput: String?,
    val onSubmitTitle: (String) -> Unit,
    val onSubmitAuthorName: (String) -> Unit,
    val onSubmitDescription: (String) -> Unit,
    val onDismiss: () -> Unit
)