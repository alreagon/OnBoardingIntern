package com.example.onboardinginternapp.data.remote.network

import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) {

    suspend fun getMovieBoundResource(parameters: HashMap<String, String>) : List<Movie> {
        return apiService.getMovieBoundResource(parameters)
    }

    suspend fun getDetailBoundResource(id : Int) : Response<MovieDetailResponse>{
        return apiService.getDetailMovePopularId(id)
    }

}