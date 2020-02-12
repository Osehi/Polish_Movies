package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.polish.polishmovies.R
import com.polish.polishmovies.databinding.FragmentDetailsBinding
import com.polish.polishmovies.model.Movies

/**
 * A simple [Fragment] subclass.
 */
class Details : Fragment() {

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

        return binding.root

    }


}
