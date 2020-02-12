package com.polish.polishmovies.repository


import android.util.Log
import com.polish.polishmovies.model.MovieResponse
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.network.MovieDataApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val API_KEY = "febc8ea7e2a2c740f57ba1d0d92204f8"

object MovieDataRepository {

    val movieDataApiService = MovieDataApiService()

    suspend fun getMovieResponse(): List<Movies>{
        var data = listOf<Movies>()
        withContext(Dispatchers.IO){
            try {
                data = movieDataApiService.getResponse("popularity.desc", API_KEY).await().movies
//                Log.d("NETWORK CALL", "${data}")

            }catch (t: Throwable){
                Log.e("Repository", t.message)


            }
        }
        return data
    }

}