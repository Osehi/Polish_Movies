package com.polish.polishmovies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.polishmovies.databinding.FavouriteItemBinding
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.utils.IMAGE_BASE_URL
import com.squareup.picasso.Picasso

class FavouriteMovieDataAdapter(val onClickListener:OnClickListener, val context:Context):ListAdapter<MovieData, FavouriteMovieDataAdapter.MovieData1ViewHolder>(DiffCallback){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteMovieDataAdapter.MovieData1ViewHolder {
        return MovieData1ViewHolder(FavouriteItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: FavouriteMovieDataAdapter.MovieData1ViewHolder,
        position: Int
    ) {
        val movieData = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movieData)

        }
        holder.binding.favoriteStateTrueId.visibility = View.VISIBLE
        holder.bind(movieData)
    }


    companion object DiffCallback:DiffUtil.ItemCallback<MovieData>(){
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class MovieData1ViewHolder( var binding:FavouriteItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movieData: MovieData){
            binding.movieData = movieData

            Picasso.get()
                .load(IMAGE_BASE_URL +"w154"+movieData.posterPath)
                .into(binding.contactAvater)

            binding.executePendingBindings()
        }

    }

    class OnClickListener(val clickListener:(movieData:MovieData)-> Unit){
        fun onClick(movieData: MovieData) = clickListener(movieData)
    }


}