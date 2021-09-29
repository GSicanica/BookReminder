package com.goransico.bookreminder.di

import com.goransico.domain.repository.BookRepository
import com.goransico.domain.usecase.book.LoadBook
import com.goransico.local.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Reusable
    fun BookRepository(): BookRepository = BookRepositoryImpl()


    @Provides
    @Reusable
    fun loadBookUseCase(bookRepository: BookRepository): LoadBook = LoadBook(bookRepository)


}