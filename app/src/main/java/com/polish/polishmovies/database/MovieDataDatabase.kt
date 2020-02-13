package com.polish.polishmovies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.polish.polishmovies.model.MovieData

@Database(entities = [MovieData::class], version = 2, exportSchema = false)
abstract class MovieDataDatabase:RoomDatabase() {

    abstract fun movieDataDao():MovieDataDao

    companion object{
        @Volatile
        private var INSTANCE:MovieDataDatabase? = null
        fun getInstance(context: Context):MovieDataDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDataDatabase::class.java,
                        "movieData_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}