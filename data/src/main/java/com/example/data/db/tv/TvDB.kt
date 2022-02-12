package com.example.data.db.tv

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Tv

@Entity(tableName = "tv")
data class TvDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val original_name: String,
    val overview: String,
    val backdropPath: String,
    val type: String
) {
    fun toTvEntity() = Tv(
        originalName = original_name,
        overview = overview,
        backdrop_path = backdropPath
    )
}
