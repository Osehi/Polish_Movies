package com.polish.polishmovies.database

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.polish.polishmovies.getOrAwaitValue
import com.polish.polishmovies.model.MovieData
import io.mockk.MockKAnnotations
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MovieDataDatabaseTest {

    private var application: Application = mockk()
    private lateinit var database:MovieDataDatabase
    private lateinit var movieDataDao:MovieDataDao
    private lateinit var movieData:MovieData

    private val mainThreadTest = newSingleThreadContext("UI thread")
    @get:Rule
    val instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){

        MockKAnnotations.init(this)
        movieData = MovieData(0, "en", "The Bird of Prey is a must wa", "hycgjjuaa", "2020", "Birds of Prey", 5.0, true)
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), MovieDataDatabase::class.java).build()
        movieDataDao = database.movieDataDao()

        Dispatchers.setMain(mainThreadTest)

    }

    @After
    fun tearDown(){
        database.close()
    }


    /*
    * Data is stored into database correctly
     */
    @Test
    @Throws(Exception::class)
    fun `database stores data`(){
        runBlocking{
            launch(Dispatchers.Main){
                // when
                movieDataDao.insertFavorite(movieData)

                //Then
                val outcome = movieDataDao.getAllFavorite()
                assertNotNull(outcome.getOrAwaitValue())
            }
        }
    }

//    @Test
//    fun `database can delete stored data`(){
//
//        runBlocking{
//            launch(Dispatchers.Main){
//                // add new data to database
//                movieDataDao.insertFavorite(movieData)
//
//                // when
//                movieDataDao.deleteFavorite(movieData)
//
//                // Then
//                val outcome = movieDataDao.getAllFavorite()
//                assertEquals(outcome.getOrAwaitValue().size, 0)
//            }
//        }
//
//    }


}