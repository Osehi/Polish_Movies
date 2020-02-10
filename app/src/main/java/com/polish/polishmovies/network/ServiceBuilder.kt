package com.polish.polishmovies.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    // the url
    private const val URL = "https://api.themoviedb.org/3/discover/"

    // create okHttp client
    private val okHttp = OkHttpClient.Builder()

    // create a Retrofit builder
    private val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    // create a retrofit instance
    private val retrofit = builder.build()

    // create the api
    fun <T> builderService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }



}