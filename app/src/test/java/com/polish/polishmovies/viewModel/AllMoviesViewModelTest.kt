package com.polish.polishmovies.viewModel

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.polish.polishmovies.getOrAwaitValue
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class AllMoviesViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun getAllMoviesData(){

        // Given a AllMoviesViewModel
        val allMoviesViewModel = AllMoviesViewModel(ApplicationProvider.getApplicationContext())


        assertEquals(allMoviesViewModel.workingModel.getOrAwaitValue(), true)

    }
    // this test shows that a response comes when there is a call to the viewModel

}