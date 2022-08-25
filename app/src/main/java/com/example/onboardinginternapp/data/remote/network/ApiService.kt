package com.example.onboardinginternapp.data.remote.network

import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>

    //Get movies popular
    @GET("movie/popular")
    suspend fun getMovieBoundResource(
        @QueryMap parameters: HashMap<String,String>
    ): List<Movie>

    //Get detail movie detail id
    @GET("movie/{movie_id}")
    suspend fun getDetailMovePopularId(
        @Path("movie_id") id : Int
    ) : Response<MovieDetailResponse>

}

