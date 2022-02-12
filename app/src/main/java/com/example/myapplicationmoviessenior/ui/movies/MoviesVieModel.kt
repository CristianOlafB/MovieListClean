package com.example.myapplicationmoviessenior.ui.movies


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.GetTvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesVieModel @Inject constructor(
    private val app: Application,
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getTvUseCase: GetTvUseCase
) : ViewModel() {

    fun getMoviesRec() = viewModelScope.launch(Dispatchers.IO) {
        getMoviesUseCase.getInsertDb()
    }

    fun getMoviesRecLoc() = liveData {
        getMoviesUseCase.executeRec().collect {
            emit(it)
        }
    }

    fun getMoviesRatLoc() = liveData {
        getMoviesUseCase.executeRat().collect {
            emit(it)
        }
    }

    fun getMoviesPopLoc() = liveData {
        getMoviesUseCase.executePop().collect {
            emit(it)
        }
    }

    fun getTvRec() = viewModelScope.launch(Dispatchers.IO) {
        getTvUseCase.getInsertDbTv()
    }

    fun getTvRecLoc() = liveData {
        getTvUseCase.executeRecTv().collect {
            emit(it)
        }
    }

    fun getTvRatLoc() = liveData {
        getTvUseCase.executeRatTv().collect {
            emit(it)
        }
    }

    fun getTvPopLoc() = liveData {
        getTvUseCase.executePopTv().collect {
            emit(it)
        }
    }


}