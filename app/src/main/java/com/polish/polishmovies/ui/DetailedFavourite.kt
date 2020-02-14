package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.polish.polishmovies.R
import com.polish.polishmovies.databinding.FragmentDetailedFavouriteBinding
import com.polish.polishmovies.utils.IMAGE_BASE_URL
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class DetailedFavourite : Fragment() {

    val arg:DetailedFavouriteArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detailed_favourite, container, false)

        val binding = FragmentDetailedFavouriteBinding.inflate(inflater, container, false)

        binding.movieData = arg.MovieData

        // set the image to the view(on the detailed view)
        Picasso.get()
            .load(IMAGE_BASE_URL +"w154"+arg.MovieData.posterPath)
            .into(binding.detailedImagePosterId)

        return binding.root

    }


}
