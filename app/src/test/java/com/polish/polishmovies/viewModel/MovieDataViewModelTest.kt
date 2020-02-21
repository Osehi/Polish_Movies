package com.polish.polishmovies.viewModel

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.polish.polishmovies.getOrAwaitValue
import com.polish.polishmovies.model.MovieData
import com.polish.polishmovies.model.Movies
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class MovieDataViewModelTest {

    private val mainThreadTest = newSingleThreadContext("UI thread")

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var favoriteMovieDataViewModel:MovieDataViewModel

    @Before
    fun setUp(){
        favoriteMovieDataViewModel = MovieDataViewModel(ApplicationProvider.getApplicationContext())
        Dispatchers.setMain(mainThreadTest)
    }

    @After
    fun close(){
        mainThreadTest.close()
    }

    @Test
    fun saveFavouriteMovie(){
        runBlocking{
            launch(Dispatchers.Main){
                // Given a movie object
                val movieData = MovieData(0,"en","The tale of a new beginning","wfghhddlkk", "2019","Astra", 8.0, true)

                // When insert favourite function is called
                favoriteMovieDataViewModel.insertFavorite(movieData)

                // Then saveFavouriteActivated
                assertEquals(favoriteMovieDataViewModel.saveFavoriteMovieActivated, true)
            }
        }
    }


    @Test
    fun deleteFavouriteMovie(){
        runBlocking {
            launch(Dispatchers.Main){
                // Given a fresh movie
                val movieData = MovieData(0, "en", "The best is yet to be seen in the cinemas", "hdtmdlon", "2019", "The Queen of Prey", 6.0, true)

                // when delete favourite function is called
                favoriteMovieDataViewModel.deleteFavorite(movieData)

                // Then deleteFavouriteActivated
                assertEquals(favoriteMovieDataViewModel.deleteFavoriteMovieActivated,true)
            }
        }
    }

}