package com.polish.polishmovies.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.polish.polishmovies.R
import com.polish.polishmovies.databinding.FragmentDetailsBinding
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.utils.IMAGE_BASE_URL
import com.polish.polishmovies.viewModel.MovieDataViewModel
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class Details : Fragment() {

    lateinit var movieDataViewModel: MovieDataViewModel
    var movieImage:String? = null
    var movies:Movies? = null
    val args:DetailsArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false)

        val binding = FragmentDetailsBinding.inflate(inflater, container, false)

        movieDataViewModel = ViewModelProvider(this).get(MovieDataViewModel::class.java)

        movies = args.Movies
//        val(id,title) = movies!!
//        var movieImage = IMAGE_BASE_URL+"w154"+movies!!.posterPath
        val newMovie = MovieData(movies!!.id, movies!!.originalLanguage, movies!!.overview, movies!!.posterPath, movies!!.releaseDate, movies!!.title, movies!!.voteAverage,movies!!.isFavourite)
        binding.movies = movies

        // set the image to the view(on the detailed view)
        Picasso.get()
            .load(IMAGE_BASE_URL+"w154"+args.Movies!!.posterPath)
            .into(binding.detailedImagePosterId)


        binding.buttonDetailedFavoriteId.setOnClickListener {

            movieDataViewModel.inserFavorite(newMovie)
//            val action = DetailsDirections.actionDetails2ToTabHost(movies!!)
//            findNavController().navigate(action)

//            Log.d("CLICKS","${newMovie}")

            this.findNavController().navigateUp()
        }


        return binding.root

    }


}
