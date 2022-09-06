package com.example.onboardinginternapp.data.remote.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.onboardinginternapp.data.local.db.Converters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "detailMovies")
//data class MovieDetailResponse(
//    @SerializedName("adult")
//    val adult: Boolean,
//    @SerializedName("backdrop_path")
//    val backdropPath: String,
//    @SerializedName("belongs_to_collection")
//    val belongsToCollection: BelongsToCollection,
//    @SerializedName("budget")
//    val budget: Int,
//
//    @SerializedName("genres")
//    val genres: List<Genre>,
//
//    @SerializedName("homepage")
//    val homepage: String,
//
//    @PrimaryKey(autoGenerate = false) @SerializedName("id") val id: Int? = null,
//
//    @SerializedName("imdb_id")
//    val imdbId: String,
//    @SerializedName("original_language")
//    val originalLanguage: String,
//    @SerializedName("original_title")
//    val originalTitle: String,
//    @SerializedName("overview")
//    val overview: String,
//    @SerializedName("popularity")
//    val popularity: Double,
//    @SerializedName("poster_path")
//    val posterPath: String,
//
//    @SerializedName("production_companies")
//    val productionCompanies: List<ProductionCompany>,
//
//    @SerializedName("production_countries")
//    val productionCountries: List<ProductionCountry>,
//
//    @SerializedName("release_date")
//    val releaseDate: String,
//    @SerializedName("revenue")
//    val revenue: Int,
//    @SerializedName("runtime")
//    val runtime: Int,
//
//    @SerializedName("spoken_languages")
//    val spokenLanguages: List<SpokenLanguage>,
//
//    @SerializedName("status")
//    val status: String,
//    @SerializedName("tagline")
//    val tagline: String,
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("video")
//    val video: Boolean,
//    @SerializedName("vote_average")
//    val voteAverage: Double,
//    @SerializedName("vote_count")
//    val voteCount: Int
//)

//class MovieDetailTypeConverter {
//
//    // belongs
//    @TypeConverter
//    fun belongsToString(belongs: MovieDetailResponse) = Gson().toJson(belongs)
//
//    @TypeConverter
//    fun stringToBelongs(string: String) =
//        Gson().fromJson(string, Array<MovieDetailResponse>::class.java).toList()
//
//    // genre
//    @TypeConverter
//    fun genreToString(genre: MovieDetailResponse) = Gson().toJson(genre)
//
//    @TypeConverter
//    fun stringToGenre(string: String) =
//        Gson().fromJson(string, Array<MovieDetailResponse>::class.java).toList()
//
//    // productionCompany
//    @TypeConverter
//    fun proCompToString(proComp: MovieDetailResponse) = Gson().toJson(proComp)
//
//    @TypeConverter
//    fun stringToProComp(string: String) =
//        Gson().fromJson(string, Array<MovieDetailResponse>::class.java).toList()
//
//    // productionCountry
//    @TypeConverter
//    fun proCountToString(proCount: MovieDetailResponse) = Gson().toJson(proCount)
//
//    @TypeConverter
//    fun stringToProCount(string: String) =
//        Gson().fromJson(string, Array<MovieDetailResponse>::class.java).toList()
//
//    // spokenLanguage
//    @TypeConverter
//    fun spokenToString(spoken: MovieDetailResponse) = Gson().toJson(spoken)
//
//    @TypeConverter
//    fun stringToSpoken(string: String) =
//        Gson().fromJson(string, Array<MovieDetailResponse>::class.java).toList()
//
//
//}
