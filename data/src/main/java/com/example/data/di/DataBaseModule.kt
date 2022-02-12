package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.db.AppDatabase
import com.example.data.db.movie.MovieDao
import com.example.data.db.tv.TvDao
import com.example.data.util.factory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(movieDaodata: AppDatabase): MovieDao {
        return movieDaodata.movieDao()
    }

    @Singleton
    @Provides
    fun provideNewsDaoTv(movieDaodataTv: AppDatabase): TvDao {
        return movieDaodataTv.tvDao()
    }

}