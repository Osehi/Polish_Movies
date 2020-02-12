package com.polish.polishmovies.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.repository.MovieDataFavouriteRepository
import com.polish.polishmovies.ui.AllMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieDataViewModel(application: Application):AndroidViewModel(application) {

    private var repository = MovieDataFavouriteRepository(application)
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    lateinit var allMovies: LiveData<List<MovieData>>

    init {
        uiScope.launch {
            allMovies = repository.getAllFavorite()!!
        }
    }


}