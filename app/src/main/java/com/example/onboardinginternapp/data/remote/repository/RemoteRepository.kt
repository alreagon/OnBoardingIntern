package com.example.onboardinginternapp.data.remote.repository

import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.data.remote.network.ApiHelperImpl
import com.example.onboardinginternapp.data.remote.network.ApiService
import retrofit2.Call


//class RemoteRepository(
//
//    private val apiHelperImpl: ApiHelperImpl
//) {
//   suspend fun getMovieRemote(params : String): List<MovieResponse> {
//        return apiHelperImpl.getMovieRemake(params)
//    }
//
//}
//class ApiHelperImpl(private val apiService: ApiService) {
//
//    suspend fun getMovieBoundResource(parameters: String) : List<MovieResponse> {
//        return apiService.getMovieBoundResource(parameters)
//    }

//class RemoteRepository(
//    private val apiHelperImpl: ApiHelperImpl,
//    private val localDaoHelperImpl: LocalDaoHelperImpl
//) {
//
//    suspend fun getMovieBoundResource(params: String): List<Movie> {
//        val response = apiHelperImpl.getMovieBoundResource(params)
//        localDaoHelperImpl.deleteAndInsertData(response)
//        return response
//    }
//
//    fun getMovieOffline(): List<Movie> {
//        return localDaoHelperImpl.getAllMovies()
//    }
//
////    suspend fun getDetailMovieBuondResource(id :Int) : MovieDetailResponse?{
////        val response = apiHelperImpl.getDetailBoundResource(id)
////        localDaoHelperImpl.deleteAndInsertDataDetail(response.body())
////        return response
////    }
////    fun getDetailMovieOffline(): List<MovieDetailResponse>{
////        return localDaoHelperImpl.getDetailMovies()
////    }
//
//
//
//}