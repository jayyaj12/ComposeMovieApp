package com.aos.composemovieapp.module

import com.aos.domain.repository.MovieRepository
import com.aos.domain.use_case.GetBookListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieListUseCase(movieRepository: MovieRepository) = GetBookListUseCase(movieRepository)

}