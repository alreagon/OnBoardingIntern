package com.example.onboardinginternapp.data.remote.network

import androidx.lifecycle.LiveData
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {


    // Get movies popular remake
    @GET("movie/popular")
    suspend fun getMovieRemake(
    ): Response<MovieResponse>

//    @GET("movie/popular")
//    fun getMovie(
//        @Query("api_key") apiKey: String
//    ): Call<MovieResponse>

    //Get movies popular
//    @GET("movie/popular")
//    suspend fun getMovieBoundResource(
//        @Query("api_key") apiKey: String
//    ): List<MovieResponse>

    //TODO : nyobain buat response
    //Get detail movie detail id
//    @GET("movie/{movie_id}")
//    suspend fun getDetailMovePopularId(
//        @Path("movie_id") id: Int
//    ): MovieDetailResponse

}

