package com.polish.polishmovies.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.polish.polishmovies.model.MovieResponse
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val URL = "https://api.themoviedb.org/3/discover/"


interface MovieDataApiService {
    @GET("movie")
    fun getResponse(
        @Query("sort_by") sortBy: String,
        @Query("api_key") apiKey: String
    ): Deferred<MovieResponse>

    companion object{
        operator fun invoke(): MovieDataApiService{
            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build()
                .create(MovieDataApiService::class.java)
        }
    }
}