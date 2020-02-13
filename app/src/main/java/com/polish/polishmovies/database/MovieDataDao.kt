package com.polish.polishmovies.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.polish.polishmovies.model.MovieData

@Dao
interface MovieDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertFavorite(movieData: MovieData)

    @Delete
    fun deleteFavorite(movieData:MovieData)

    @Query("SELECT * FROM movieDataFavourite_table ORDER BY id ASC")
   fun getAllFavorite(): LiveData<List<MovieData>>

}