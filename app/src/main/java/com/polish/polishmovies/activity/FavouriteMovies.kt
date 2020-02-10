package com.polish.polishmovies.activity


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.polish.polishmovies.R
import kotlinx.android.synthetic.main.fragment_favourite_movies.*

/**
 * A simple [Fragment] subclass.
 */
class FavouriteMovies : Fragment() {

    lateinit var favorite:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite_movies, container, false)

        favorite = view.findViewById(R.id.buttonFavoriteId)

        favorite.setOnClickListener {
            view.findNavController().navigate(R.id.action_favouriteMovies_to_movieDetails)
        }

        return view

    }



}
