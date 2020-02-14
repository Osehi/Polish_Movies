package com.polish.polishmovies.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.repository.MovieDataFavouriteRepository
import com.polish.polishmovies.ui.AllMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieDataViewModel(application: Application):AndroidViewModel(application) {

    private var repository = MovieDataFavouriteRepository(application)

     val allMovieData = repository.getAllFavorite()

//    private var repository = MovieDataFavouriteRepository(application)
//    private var viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private var _allMovieData = MutableLiveData<List<MovieData>>()
//    val allMovieData
//    get() = _allMovieData

//    init {
//
////        uiScope.launch {
////            allMovieData = repository.getAllFavorite()!!
////        }
//        getAllMovieData()
//
//    }

//    private fun getAllMovieData(){
//        uiScope.launch {
//            _allMovieData.value = repository.getAllFavorite()
//        }
//    }
//
//
//    fun insertFavorite(movieData: MovieData){
//        uiScope.launch {
//            repository.insertFavorite(movieData)
//        }
//    }
//
//    fun deleteFavorite(movieData:MovieData){
//        uiScope.launch {
//            repository.deleteFavorite(movieData)
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

    fun inserFavorite(movieData:MovieData){
        repository.insertFavorite(movieData)
    }

    fun deleteFavorite(movieData:MovieData){
        repository.deleteFavorite(movieData)
    }



}