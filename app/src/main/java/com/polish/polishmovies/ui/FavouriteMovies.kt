package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

import com.polish.polishmovies.R

/**
 * A simple [Fragment] subclass.
 */
class FavouriteMovies : Fragment() {

    lateinit var favourite:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite_movies, container, false)

        favourite = view.findViewById(R.id.buttonFavoriteId)

        favourite.setOnClickListener {

            parentFragment!!.findNavController().navigate(R.id.action_tabHost_to_details2)
        }

        return view

    }


}
