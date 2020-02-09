package com.polish.polishmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polish.polishmovies.adapter.DPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup the tool bar and toolBar title.
        toolBarId.setTitle("Movies")
        setSupportActionBar(toolBarId)

        // setup the adapter
        val fragAdapter = DPagerAdapter(supportFragmentManager)
        viewPagerId.adapter = fragAdapter

        // connect the tablayou to the viewPager
        tablayoutId.setupWithViewPager(viewPagerId)
    }
}
