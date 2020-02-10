package com.polish.polishmovies.network

import com.polish.polishmovies.model.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie")
    fun getMovies(@Query("sort_by")sortBy:String, @Query("api_key")apiKey:String): Call<List<MovieData>>

}