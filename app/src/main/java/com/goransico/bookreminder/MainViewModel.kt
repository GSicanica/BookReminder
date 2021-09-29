package com.goransico.bookreminder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.goransico.designsystem.components.BookInputDialogConfig

class MainViewModel : ViewModel() {

    // Dialog
    var bookInputDialogConfig: BookInputDialogConfig? by mutableStateOf(null)
    var titleCandidate : String? by mutableStateOf(null)
    var authorNameCandidate : String? by mutableStateOf(null)
    var bookInfoCandidate : String? by mutableStateOf(null)


    init {
        bookInputDialogConfig = BookInputDialogConfig(
            bookTitleStringRes = R.string.book_title,
            authorNameStringRes = R.string.author_name,
            bookDescription = R.string.book_info,
            initialInput = "",
            onSubmitTitle = {
                titleCandidate = it
                bookInputDialogConfig = null
            },
            onSubmitAuthorName= {
                authorNameCandidate = it
                bookInputDialogConfig = null
            },
            onSubmitDescription = {
                bookInfoCandidate = it
                bookInputDialogConfig = null
            },
            onDismiss = {
                bookInputDialogConfig = null
            }
        )
    }

    fun onFabClick(){
            bookInputDialogConfig = BookInputDialogConfig(
            bookTitleStringRes = R.string.book_title,
            authorNameStringRes = R.string.author_name,
            bookDescription = R.string.book_info,
            initialInput = "",
            onSubmitTitle = {
                titleCandidate = it
                bookInputDialogConfig = null
            },
            onSubmitAuthorName= {
                authorNameCandidate = it
                bookInputDialogConfig = null
            },
            onSubmitDescription = {
                bookInfoCandidate = it
                bookInputDialogConfig = null
            },
            onDismiss = {
                bookInputDialogConfig = null
            }
        )
    }

}