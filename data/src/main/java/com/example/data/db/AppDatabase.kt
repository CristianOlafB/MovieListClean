package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.movie.MovieDB
import com.example.data.db.movie.MovieDao
import com.example.data.db.tv.TvDB
import com.example.data.db.tv.TvDao

@Database(
    entities = [
        MovieDB::class,
        TvDB::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}