package com.example.data.db.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Movies

@Entity(tableName = "movies")
data class MovieDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val overview: String,
    val backdropPath: String,
    val type: String
) {
    fun toMovieEntity() = Movies(
        title = title,
        overview = overview,
        backdrop_path = backdropPath
    )
}
