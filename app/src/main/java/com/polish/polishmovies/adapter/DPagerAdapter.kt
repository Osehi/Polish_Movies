package com.polish.polishmovies.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.polish.polishmovies.ui.AllMovies
import com.polish.polishmovies.ui.FavouriteMovies

class DPagerAdapter(fragMngr:FragmentManager):FragmentPagerAdapter(fragMngr, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    // this set the tab positions
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                AllMovies()
            }
            else->{
                return FavouriteMovies()
            }
        }
    }

    // this method return 2 tabs
    override fun getCount(): Int {
        return 2
    }

    // this sets the tab title
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "All Movies"
            else-> {
                return "Favourite Movies"
            }
        }
    }

}