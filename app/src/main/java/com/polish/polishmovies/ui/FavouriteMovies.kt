package com.polish.polishmovies.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.polish.polishmovies.R
import com.polish.polishmovies.adapter.DetailsMovieDataAdapter
import com.polish.polishmovies.databinding.FragmentFavouriteMoviesBinding
import com.polish.polishmovies.viewModel.MovieDataViewModel

/**
 * A simple [Fragment] subclass.
 */
class FavouriteMovies : Fragment() {

    lateinit var movieDataViewModel:MovieDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return  inflater.inflate(R.layout.fragment_favourite_movies, container, false)

        val binding = FragmentFavouriteMoviesBinding.inflate(inflater, container, false)

        movieDataViewModel = ViewModelProvider(this).get(MovieDataViewModel::class.java)

        val recyclerview = binding.recyclerViewFavoriteId
        recyclerview.layoutManager = LinearLayoutManager(context)

        var adapter = DetailsMovieDataAdapter(DetailsMovieDataAdapter.OnClickListener{})

        recyclerview.adapter = adapter

        movieDataViewModel.allMovieData.observe(viewLifecycleOwner, Observer {
            it?.let {
//                Log.d("RECYCLERVIEW", "Adding")
                adapter.submitList(it)
            }
        })


//       ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){
//           override fun onMove(
//               recyclerView: RecyclerView,
//               viewHolder: RecyclerView.ViewHolder,
//               target: RecyclerView.ViewHolder
//           ): Boolean {
//               return false
//           }
//
//           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//               movieDataViewModel.deleteFavorite(adapter.getItemId(viewHolder.adapterPosition))
//           }
//
//       })



        return binding.root

    }


}
