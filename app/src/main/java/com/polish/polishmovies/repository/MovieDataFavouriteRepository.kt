package com.polish.polishmovies.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.polish.polishmovies.database.MovieDataDao
import com.polish.polishmovies.database.MovieDataDatabase
import com.polish.polishmovies.model.MovieData
import kotlinx.coroutines.*

class MovieDataFavouriteRepository(application: Application)  {

//    private var viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var movieDataDao:MovieDataDao

//    private var allFavorite: LiveData<List<MovieData>>

    init {

        val database:MovieDataDatabase = MovieDataDatabase.getInstance(application.applicationContext)

        movieDataDao = database.movieDataDao()


//        allFavorite = movieDataDao.getAllFavorite()
    }

   suspend  fun getAllFavorite(): LiveData<List<MovieData>>? {
       var data: LiveData<List<MovieData>>? = null
        withContext(Dispatchers.IO){
            data = movieDataDao.getAllFavorite()
        }
       return data
    }

   suspend fun insertFavorite(movieData: MovieData){
       withContext(Dispatchers.IO){
           movieDataDao.insertFavorite(movieData)
       }
    }

   suspend fun deleteFavorite(movieData:MovieData){
       withContext(Dispatchers.IO){
           movieDataDao.deleteFavorite(movieData)
       }
    }




}