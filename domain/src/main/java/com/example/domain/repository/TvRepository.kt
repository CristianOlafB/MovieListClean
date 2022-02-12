package com.example.domain.repository

import com.example.domain.model.Tv
import kotlinx.coroutines.flow.Flow

interface TvRepository {
    suspend fun getInsertDbTv()
    suspend fun getTvRec(): Flow<List<Tv>>
    suspend fun getTvRat(): Flow<List<Tv>>
    suspend fun getTvPop(): Flow<List<Tv>>
}