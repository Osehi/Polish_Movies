package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs

import com.polish.polishmovies.R
import com.polish.polishmovies.databinding.FragmentDetailsBinding
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.utils.IMAGE_BASE_URL
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class Details : Fragment() {

    lateinit var imageLocation:ImageView

    var movies:Movies? = null
    val args:DetailsArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false)

        val binding = FragmentDetailsBinding.inflate(inflater, container, false)



        binding.movies = args.Movies
        // set the image to the view
        Picasso.get()
            .load(IMAGE_BASE_URL+"w154"+args.Movies.posterPath)
            .into(binding.detailedImagePosterId)

        return binding.root

    }


}
