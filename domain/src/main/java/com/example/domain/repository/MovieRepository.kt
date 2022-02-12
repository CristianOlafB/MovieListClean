package com.example.domain.repository

import com.example.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getInsertDb()
    suspend fun getMoviesRec(): Flow<List<Movies>>
    suspend fun getMoviesRat(): Flow<List<Movies>>
    suspend fun getMoviesPop(): Flow<List<Movies>>
}