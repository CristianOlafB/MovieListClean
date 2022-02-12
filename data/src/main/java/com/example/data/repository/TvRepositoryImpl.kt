package com.example.data.repository

import com.example.data.api.ApiServiceTv
import com.example.data.db.AppDatabase
import com.example.domain.model.Tv
import com.example.domain.repository.TvRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TvRepositoryImpl @Inject constructor(
    private val apiServiceTv: ApiServiceTv,
    private val db: AppDatabase
) : TvRepository {

    override suspend fun getInsertDbTv() {
        try {

            val apiResponse = apiServiceTv.getTvRec()
            val response = apiResponse.results.map { it.toConvertTvRec() }
            db.tvDao().insertTv(response)

            val apiResponseRat = apiServiceTv.getTvRat()
            val reposRat = apiResponseRat.results.map { it.toConvertTvRat() }
            db.tvDao().insertTv(reposRat)

            val apiResponsePop = apiServiceTv.getTvPop()
            val reposPop = apiResponsePop.results.map { it.toConvertTvPop() }
            db.tvDao().insertTv(reposPop)

        } catch (e: Exception) {
            println(e.message)
        }
    }

    override suspend fun getTvRec(): Flow<List<Tv>> {
        return db.tvDao().getTvRec().map {
            it.map { tvDB ->
                tvDB.toTvEntity()
            }
        }
    }

    override suspend fun getTvRat(): Flow<List<Tv>> {
        return db.tvDao().getTvRat().map {
            it.map { tvDB ->
                tvDB.toTvEntity()
            }
        }
    }

    override suspend fun getTvPop(): Flow<List<Tv>> {
        return db.tvDao().getTvPop().map {
            it.map { tvDB ->
                tvDB.toTvEntity()
            }
        }
    }

}