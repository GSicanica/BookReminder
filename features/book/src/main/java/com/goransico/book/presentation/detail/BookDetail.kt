package com.goransico.book.presentation.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal inline class BookId(val value: Long?) : Parcelable

@Parcelize
internal inline class CategoryId(val value: Long?) : Parcelable