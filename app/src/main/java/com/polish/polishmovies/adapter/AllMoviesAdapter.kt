package com.polish.polishmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.polishmovies.databinding.MovieItemBinding
import com.polish.polishmovies.model.MovieData

class AllMoviesAdapter(private val onClickListener:OnClickListener):ListAdapter<MovieData, AllMoviesAdapter.MovieDataViewHolder>(DiffCallback) {


    class MovieDataViewHolder(private var binding:MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movieData: MovieData){
            binding.movieData = movieData

            binding.executePendingBindings()
        }

    }

    companion object DiffCallback:DiffUtil.ItemCallback<MovieData>(){
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDataViewHolder {
        return MovieDataViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieDataViewHolder, position: Int) {
        val movieData = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movieData)
        }
        holder.bind(movieData)
    }


    class OnClickListener(val clickListener:(movieData:MovieData) -> Unit){
        fun onClick(movieData: MovieData) = clickListener(movieData)
    }
}


