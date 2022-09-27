package com.example.onboardinginternapp.data.remote.network

import com.example.onboardinginternapp.data.remote.model.MovieResponse


class ApiHelperImpl(private val apiService: ApiService) {

    suspend fun getMovieRemake(prams : HashMap<String, String>):List<MovieResponse>{
        return apiService.getMovieRemake(prams)
    }
//    suspend fun getMovieBoundResource(parameters: String) : List<MovieResponse> {
//        return apiService.getMovieBoundResource(parameters)
//    }

//    suspend fun getDetailBoundResource(id : Int) : Response<MovieDetailResponse>{
//        return apiService.getDetailMovePopularId(id)
//    }

}