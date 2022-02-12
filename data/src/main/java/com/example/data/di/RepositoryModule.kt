package com.example.data.di

import com.example.data.api.ApiService
import com.example.data.api.ApiServiceTv
import com.example.data.db.AppDatabase
import com.example.data.repository.MovieRepositoryImpl
import com.example.data.repository.TvRepositoryImpl
import com.example.domain.repository.MovieRepository
import com.example.domain.repository.TvRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: ApiService,
        db: AppDatabase
    ): MovieRepository = MovieRepositoryImpl(apiService, db)

    @Singleton
    @Provides
    fun provideTvRepository(
        apiServiceTv: ApiServiceTv,
        db: AppDatabase
    ): TvRepository = TvRepositoryImpl(apiServiceTv, db)

}