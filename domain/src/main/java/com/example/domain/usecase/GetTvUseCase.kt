package com.example.domain.usecase

import com.example.domain.model.Tv
import com.example.domain.repository.TvRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTvUseCase @Inject constructor(
    private val tvRepository: TvRepository
) {
    suspend fun getInsertDbTv() {
        return tvRepository.getInsertDbTv()
    }

    suspend fun executeRecTv(): Flow<List<Tv>> {
        return tvRepository.getTvRec()
    }

    suspend fun executeRatTv(): Flow<List<Tv>> {
        return tvRepository.getTvRat()
    }

    suspend fun executePopTv(): Flow<List<Tv>> {
        return tvRepository.getTvPop()
    }
}