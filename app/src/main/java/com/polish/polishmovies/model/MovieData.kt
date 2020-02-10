package com.polish.polishmovies.model


import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(

    var id: Int,

    var posterPath: String,

    var releaseDate: String,

    var title: String,

    var voteAverage: Int

):Parcelable {
//    var isFavourite:Boolean?
}