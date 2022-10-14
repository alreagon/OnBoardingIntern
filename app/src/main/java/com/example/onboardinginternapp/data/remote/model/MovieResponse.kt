package com.example.onboardinginternapp.data.remote.model

class MovieResponse(

//    @PrimaryKey(autoGenerate = true)
//    @field:SerializedName("page")
//    val page: Int,

    val results: List<Movie>?
)

//class MovieTypeConverter {
//    @TypeConverter
//    fun movieToString(moviee: Movie?) = Gson().toJson(moviee)
//
//    @TypeConverter
//    fun stringToMovie(string : String) = Gson().fromJson(string, Array<Movie>::class.java).toList()
//}











