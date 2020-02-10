package com.polish.polishmovies.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.polishmovies.adapter.AllMoviesAdapter
import com.polish.polishmovies.model.MovieData

@BindingAdapter("")
fun bindRecyclerViewAllMovie(recyclerView1: RecyclerView, data:List<MovieData>?){
    val adapter = recyclerView1.adapter as AllMoviesAdapter
    adapter.submitList(data)

}