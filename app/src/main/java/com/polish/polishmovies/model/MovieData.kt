package com.polish.polishmovies.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MovieData(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var originalLanguage: String,

    var overview: String,

    var posterPath: String,

    var releaseDate: String,

    var title: String,

    var voteAverage: Double



):Parcelable {
   var isFavourite:Boolean? = null
}