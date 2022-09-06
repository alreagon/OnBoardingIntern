package com.example.onboardinginternapp.data.local.db

import androidx.room.TypeConverter
import com.example.onboardinginternapp.data.remote.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class Converters {


//    @TypeConverter
//    fun listToJson(value: List<Movie>?) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToList(value: String) = Gson().fromJson(value, Array<Movie>::class.java).toList()


    // movie response
    @TypeConverter
    fun fromMovieResponse(movieResponse: MovieResponse): String {
        return JSONObject().apply {
            put("page", movieResponse.page)
            put("result", movieResponse.results)
        }.toString()
    }

    @TypeConverter
    fun toMovieResponse(movie: String): MovieResponse {
        val json = JSONObject(movie)
        return MovieResponse(
            json.getInt("page"),
            json.get("result") as List<Movie>
        )
    }


    // movie
    @TypeConverter
    fun fromMovie(movie: Movie): String {
        return JSONObject().apply {
            put("overview", movie.overview)
            put("title", movie.title)
            put("poster_path", movie.posterPath)
            put("backdrop_path", movie.backdropPath)
            put("release_date", movie.releaseDate)
            put("popularity", movie.popularity)
            put("vote_average", movie.voteAverage)
            put("id", movie.id)
            put("vote_count", movie.voteCount)
        }.toString()
    }

    @TypeConverter
    fun toMovie(movie: String): Movie {
        val json = JSONObject(movie)
        return Movie(
            json.getString("overview"),
            json.getString("title"),
            json.getString("poster_path"),
            json.getString("backdrop_path"),
            json.getString("release_date"),
            json.getDouble("popularity"),
            json.getDouble("vote_average"),
            json.getInt("vote_count"),
            json.getInt("id"),
            )
    }

    // movie detail genre
//    @TypeConverter
//    fun frommovieDetailGenre(movieDetailGenre: Genre): String {
//        return JSONObject().apply {
//            put("id", movieDetailGenre.id)
//            put("name", movieDetailGenre.name)
//        }.toString()
//    }
//
//    @TypeConverter
//    fun tomovieDetailGenre(movieDetailGenre: String): Genre {
//        val json = JSONObject(movieDetailGenre)
//        return Genre(
//            json.getInt("id"),
//            json.getString("name")
//        )
//    }
//
//    // movie detail ProductionCompany
//    @TypeConverter
//    fun frommovieDetailProductionCompany(movieDetailProductionCompany: ProductionCompany): String {
//        return JSONObject().apply {
//            put("id", movieDetailProductionCompany.id)
//            put("logo_path", movieDetailProductionCompany.logoPath)
//            put("name", movieDetailProductionCompany.name)
//            put("origin_country", movieDetailProductionCompany.originCountry)
//        }.toString()
//    }
//
//    @TypeConverter
//    fun tomovieDetailProductionCompany(movieDetailProductionCompany: String): ProductionCompany {
//        val json = JSONObject(movieDetailProductionCompany)
//        return ProductionCompany(
//            json.getInt("id"),
//            json.getString("logo_path"),
//            json.getString("name"),
//            json.getString("origin_country")
//        )
//    }
//
//    // movie detail ProductionCountry
//    @TypeConverter
//    fun frommovieDetailProductionCountry(movieDetailProductionCountry: ProductionCountry): String {
//        return JSONObject().apply {
//            put("iso_3166_1", movieDetailProductionCountry.iso31661)
//            put("name", movieDetailProductionCountry.name)
//        }.toString()
//    }
//
//    @TypeConverter
//    fun tomovieDetailProductionCountry(movieDetailProductionCountry: String): ProductionCountry {
//        val json = JSONObject(movieDetailProductionCountry)
//        return ProductionCountry(
//            json.getString("iso_3166_1"),
//            json.getString("name")
//        )
//    }
//
//    // movie detail SpokenLanguage
//    @TypeConverter
//    fun frommovieDetailSpokenLanguage(movieDetailSpokenLanguage: SpokenLanguage): String {
//        return JSONObject().apply {
//            put("english_name", movieDetailSpokenLanguage.englishName)
//            put("iso_639_1", movieDetailSpokenLanguage.iso6391)
//            put("name", movieDetailSpokenLanguage.name)
//        }.toString()
//    }
//
//    @TypeConverter
//    fun tomovieDetailSpokenLanguage(movieDetailSpokenLanguage: String): SpokenLanguage {
//        val json = JSONObject(movieDetailSpokenLanguage)
//        return SpokenLanguage(
//            json.getString("english_name"),
//            json.getString("iso_639_1"),
//            json.getString("name")
//        )
//    }



//    @TypeConverter
//    fun fromGenreIdsList(list: List<Int>): String {
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    fun toGenreIdsList(genreIdsJson: String): List<Int> {
//        val type = object : TypeToken<List<Int>>(){}.type
//        return Gson().fromJson(genreIdsJson, type)
//    }
//
//    @TypeConverter
//    fun fromCountryList(list: List<String>): String {
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    fun toCountryList(countryJson: String): List<String> {
//        val type = object : TypeToken<List<String>>(){}.type
//        return Gson().fromJson(countryJson, type)
//    }
}