package com.example.domain.usecase

import com.example.domain.model.Movies
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun getInsertDb(){
        return movieRepository.getInsertDb()
    }

    suspend fun executeRec(): Flow<List<Movies>> {
        return movieRepository.getMoviesRec()
    }

    suspend fun executeRat(): Flow<List<Movies>> {
        return movieRepository.getMoviesRat()
    }

    suspend fun executePop(): Flow<List<Movies>> {
        return movieRepository.getMoviesPop()
    }
}