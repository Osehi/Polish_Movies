package com.polish.polishmovies.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.polish.polishmovies.model.MovieData

@Dao
interface MovieDataDao {

    @Insert
   suspend fun insertFavorite(movieData: MovieData)

    @Delete
   suspend fun deleteFavorite(movieData:MovieData)

    @Query("SELECT * FROM movieDataFavourite_table ORDER BY id DESC")
    fun getAllFavorite(): LiveData<List<MovieData>>

}