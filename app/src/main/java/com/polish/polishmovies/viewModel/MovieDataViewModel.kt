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



    fun insertFavorite(movieData:MovieData){
        repository.insertFavorite(movieData)
    }

    fun deleteFavorite(movieData:MovieData){
        repository.deleteFavorite(movieData)
    }



}