package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.db.AppDatabase
import com.example.domain.model.Movies
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) : MovieRepository {

    override suspend fun getInsertDb(){
        try {
            val apiResponse = apiService.getMoviesRec()
            val repos = apiResponse.movies.map { it.toConvertMovieRec() }
            db.movieDao().deleteAllMovies()
            db.movieDao().insertMovie(repos)

            val apiResponseRat = apiService.getMoviesRat()
            val reposRat = apiResponseRat.movies.map { it.toConvertMovieRat() }
            db.movieDao().insertMovie(reposRat)

            val apiResponsePop = apiService.getMoviesPop()
            val reposPop = apiResponsePop.movies.map { it.toConvertMoviePop() }
            db.movieDao().insertMovie(reposPop)

        } catch (e: Exception) {
            println(e.message)
        }
    }

    override suspend fun getMoviesRec(): Flow<List<Movies>> {
        return db.movieDao().getMoviesRec().map {
            it.map { movieDB ->
                movieDB.toMovieEntity()
            }
        }
    }

    override suspend fun getMoviesRat(): Flow<List<Movies>> {
        return db.movieDao().getMoviesRat().map {
            it.map { movieDB ->
                movieDB.toMovieEntity()
            }
        }
    }

    override suspend fun getMoviesPop(): Flow<List<Movies>> {
        return db.movieDao().getMoviesPop().map {
            it.map { movieDB ->
                movieDB.toMovieEntity()
            }
        }
    }

}