package com.example.data.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(photos: List<MovieDB>)

    @Query("DELETE FROM movies")
    fun deleteAllMovies()

    @Query("SELECT * FROM movies WHERE type = 'Recommendations' ")
    fun getMoviesRec(): Flow<List<MovieDB>>

    @Query("SELECT * FROM movies WHERE type = 'Rated' ")
    fun getMoviesRat(): Flow<List<MovieDB>>

    @Query("SELECT * FROM movies WHERE type = 'Favorite' ")
    fun getMoviesPop(): Flow<List<MovieDB>>

}