package com.polish.polishmovies.model


import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(

    val adult: Boolean,

    val backdropPath: String,

    val genreIds: List<Int>,

    val id: Int,

    val originalLanguage: String,

    val originalTitle: String,

    val overview: String,

    val popularity: Double,

    val posterPath: String,

    val releaseDate: String,

    val title: String,

    val video: Boolean,

    val voteAverage: Int,

    val voteCount: Int

):Parcelable {
//    var isFavourite:Boolean?
}