package com.example.onboardinginternapp.data.remote.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "moviesResponse")
data class MovieResponse(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Movie>,
)

//@Entity(tableName = "movies")
data class Movie(

    @SerializedName("overview")
    val overview: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("vote_average")
    val voteAverage: Double,

//    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("vote_count")
    val voteCount: Int
)

//class MovieTypeConverter {
//    @TypeConverter
//    fun movieToString(moviee: Movie?) = Gson().toJson(moviee)
//
//    @TypeConverter
//    fun stringToMovie(string : String) = Gson().fromJson(string, Array<Movie>::class.java).toList()
//}
//data class Movie(
//
//    @field:SerializedName("overview")
//    val overview: String,
//
//    @field:SerializedName("title")
//    val title: String,
//
//    @field:SerializedName("poster_path")
//    val posterPath: String,
//
//    @field:SerializedName("backdrop_path")
//    val backdropPath: String,
//
//    @field:SerializedName("release_date")
//    val releaseDate: String,
//
//    @field:SerializedName("popularity")
//    val popularity: Double,
//
//    @field:SerializedName("vote_average")
//    val voteAverage: Double,
//
//    @PrimaryKey
//    @field:SerializedName("id")
//    val id: Int,
//
//    @field:SerializedName("vote_count")
//    val voteCount: Int
//) : Parcelable














