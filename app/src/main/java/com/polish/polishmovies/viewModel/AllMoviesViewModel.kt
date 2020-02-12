package com.polish.polishmovies.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.repository.MovieDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AllMoviesViewModel(application: Application) : AndroidViewModel(application){

    private val repository = MovieDataRepository
    // create a coroutinescope
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _allMovies = MutableLiveData<List<Movies>>()
    val allMovies
    get() = _allMovies


    init {

        getDataFromRepository()

    }


    private fun getDataFromRepository(){

        viewModelScope.launch {
            _allMovies.value = repository.getMovieResponse()
        }

    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }



}