package com.polish.polishmovies.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.polish.polishmovies.R
import com.polish.polishmovies.adapter.DetailsMovieDataAdapter
import com.polish.polishmovies.databinding.FragmentFavouriteMoviesBinding
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.viewModel.MovieDataViewModel

/**
 * A simple [Fragment] subclass.
 */
class FavouriteMovies : Fragment() {

    var movie:Movies? = null

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

//        val movie = MovieData(movie!!.id, movie!!.title, movie!!.overview, movie!!.posterPath, movie!!.releaseDate, movie!!.voteAverage.toString(),movie!!.isFavorite)

        var adapter = DetailsMovieDataAdapter(DetailsMovieDataAdapter.OnClickListener{MovieData ->
            val action = TabHostDirections.actionTabHostToDetailedFavourite(MovieData)
            findNavController().navigate(action)
            Toast.makeText(context, "Favourite Movie", Toast.LENGTH_SHORT).show()
            Log.d("Touch", "detailed")
        }, context!!)

        recyclerview.adapter = adapter

        movieDataViewModel.allMovieData.observe(viewLifecycleOwner, Observer {
            it?.let {
//                Log.d("RECYCLERVIEW", "Adding")
                adapter.submitList(it)
            }
        })

    // swipe to left to delete item-list
       ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
           override fun onMove(
               recyclerView: RecyclerView,
               viewHolder: RecyclerView.ViewHolder,
               target: RecyclerView.ViewHolder
           ): Boolean {
               return false
           }

           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

               val mAlerDialog = AlertDialog.Builder(viewHolder.itemView.context)
               mAlerDialog.setTitle("Remove Favourite Movie")
               mAlerDialog.setMessage("This will be removed from your favourite list")
               mAlerDialog.setPositiveButton("Remove"){
                   dialog, which ->
                   val movie = adapter.currentList.get(viewHolder.adapterPosition)
                   movieDataViewModel.deleteFavorite(movie)
                   Toast.makeText(context, "Favourite movie removed", Toast.LENGTH_SHORT).show()
               }
               mAlerDialog.setNegativeButton("Cancel"){
                   dialog, which ->
                   adapter.notifyDataSetChanged()
                   dialog.dismiss()
               }
               mAlerDialog.show()



           }

       }).attachToRecyclerView(binding.recyclerViewFavoriteId)



        return binding.root

    }


}
