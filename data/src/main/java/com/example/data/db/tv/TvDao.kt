package com.example.data.db.tv

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(photos: List<TvDB>)

    @Query("DELETE FROM tv")
    fun deleteAllTv()

    @Query("SELECT * FROM tv WHERE type = 'Recommendations' ")
    fun getTvRec(): Flow<List<TvDB>>

    @Query("SELECT * FROM tv WHERE type = 'Rated' ")
    fun getTvRat(): Flow<List<TvDB>>

    @Query("SELECT * FROM tv WHERE type = 'Favorite' ")
    fun getTvPop(): Flow<List<TvDB>>

}