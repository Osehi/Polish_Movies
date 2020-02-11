package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

import com.polish.polishmovies.R
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.network.MovieService
import com.polish.polishmovies.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class AllMovies : Fragment() {

    lateinit var allMovies:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_movies, container, false)

        // rhe call
        val movieService = ServiceBuilder.builderService(MovieService::class.java)
        val requestCall = movieService.getMovies(sortBy = "popularity.desc", apiKey = "febc8ea7e2a2c740f57ba1d0d92204f8")

        requestCall.enqueue(object: Callback<List<MovieData>> {
            override fun onResponse(
                call: Call<List<MovieData>>,
                response: Response<List<MovieData>>
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<List<MovieData>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        return view

    }


}
