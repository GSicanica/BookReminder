package com.goransico.bookreminder.components

import androidx.annotation.StringRes

class BookInputDialogConfig(
    @StringRes val titleStringRes: Int,
    val initialInput: String?,
    val onSubmit: (String) -> Unit,
    val onDismiss: () -> Unit
)