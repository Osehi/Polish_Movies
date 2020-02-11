package com.polish.polishmovies.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.polish.polishmovies.R
import com.polish.polishmovies.adapter.AllMoviesAdapter
import com.polish.polishmovies.adapter.DPagerAdapter

/**
 * A simple [Fragment] subclass.
 */
class TabHost : Fragment() {
    lateinit var viewPager:ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab_host, container, false)

        viewPager = view.findViewById(R.id.viewPagerId)
        tabLayout = view.findViewById((R.id.tablayoutId))


                // setup the tool bar and toolBar title.
//        toolBarId.setTitle("Movies")
//        setSupportActionBar(toolBarId)

        // setup the adapter
        val fragAdapter = DPagerAdapter(childFragmentManager)
        viewPager.adapter = fragAdapter

        // connect the tablayou to the viewPager
        tabLayout.setupWithViewPager(viewPager)

        return view
    }



}
