package com.polish.polishmovies.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.polish.polishmovies.adapter.AllMoviesAdapter
import com.polish.polishmovies.databinding.FragmentAllMoviesBinding
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.model.Movies

import com.polish.polishmovies.viewModel.AllMoviesViewModel

/**
 * A simple [Fragment] subclass.
 */
class AllMovies : Fragment() {

    lateinit var allMovies:Button
    private lateinit var allMoviesViewModel:AllMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_all_movies, container, false)
        val binding = FragmentAllMoviesBinding.inflate(inflater, container, false)

        allMoviesViewModel = ViewModelProvider(this).get(AllMoviesViewModel::class.java)

        val recyclerView = binding.recyclerViewAllMoviesID
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = AllMoviesAdapter(AllMoviesAdapter.OnClickListener {movies->
            val action = TabHostDirections.actionTabHostToDetails2(movies)
            findNavController().navigate(action)
        },context!! )


        recyclerView.adapter = adapter

        allMoviesViewModel.allMovies.observe(viewLifecycleOwner, Observer {
            it?.let {

                adapter.submitList(it)
            }
        })



        return binding.root

    }


}
