package com.polish.polishmovies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.polishmovies.databinding.MovieItemBinding
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.model.Movies
import com.polish.polishmovies.utils.IMAGE_BASE_URL
import kotlinx.coroutines.withContext

class AllMoviesAdapter(val onClickListener:OnClickListener, val context:Context):ListAdapter<Movies, AllMoviesAdapter.MovieDataViewHolder>(DiffCallback) {


    class MovieDataViewHolder( var binding:MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies){
            binding.movies = movies

            binding.executePendingBindings()


        }

    }

    companion object DiffCallback:DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDataViewHolder {
        return MovieDataViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieDataViewHolder, position: Int) {
        val movies = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movies)
            Glide.with(context)
                .load(IMAGE_BASE_URL+"w154"+movies.posterPath)
                .into(holder.binding.contactAvater)

        }
        holder.bind(movies)
    }


    class OnClickListener(val clickListener:(movies:Movies) -> Unit){
        fun onClick(movies: Movies) = clickListener(movies)
    }

    interface ItemClickListener{
        fun onItemClickListener(i : Int)
    }
}


