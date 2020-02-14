package com.polish.polishmovies.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.polish.polishmovies.database.MovieDataDao
import com.polish.polishmovies.database.MovieDataDatabase
import com.polish.polishmovies.model.MovieData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieDataFavouriteRepository(application: Application):CoroutineScope  {



    private var movieDataDao:MovieDataDao

//    private var allFavorite: LiveData<List<MovieData>>

    init {

//        val database:MovieDataDatabase = MovieDataDatabase.getInstance(application.applicationContext)
        val database = MovieDataDatabase.getInstance(application)

        movieDataDao = database.movieDataDao()

//        allFavorite = movieDataDao.getAllFavorite()
    }

    fun getAllFavorite() = movieDataDao.getAllFavorite()

    fun insertFavorite(movieData:MovieData){
        launch { insertFavoriteOffUiThread(movieData) }
    }

    fun deleteFavorite(movieData:MovieData){
        launch { deleteFavoriteOffUiThread(movieData) }
    }


    private suspend fun insertFavoriteOffUiThread(movieData:MovieData){
        withContext(Dispatchers.IO){
            movieDataDao.insertFavorite(movieData)
        }
    }


    private suspend fun deleteFavoriteOffUiThread(movieData:MovieData){
        withContext(Dispatchers.IO){
            movieDataDao.deleteFavorite(movieData)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


}