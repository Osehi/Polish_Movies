package com.polish.polishmovies.activity


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.polish.polishmovies.R
import kotlinx.android.synthetic.main.fragment_all_movies.*

/**
 * A simple [Fragment] subclass.
 */
class AllMovies : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_movies, container, false)

//        buttonAllMoviesId.setOnClickListener {
//            view.findNavController().navigate(R.id.action_allMovies2_to_movieDetails)
//        }


        return view

    }


}
