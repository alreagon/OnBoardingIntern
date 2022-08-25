package com.example.onboardinginternapp.data.remote.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponse(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("results")
    val results: List<Movie>,
)

@Entity(tableName = "movies")
@Parcelize
data class Movie(

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @PrimaryKey
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("vote_count")
    val voteCount: Int
) : Parcelable

class MovieTypeConverter {
    @TypeConverter
    fun movieToString(moviee: Movie?) = Gson().toJson(moviee)

    @TypeConverter
    fun stringToMovie(string : String) : Movie = Gson().fromJson(string, Movie::class.java)




}












