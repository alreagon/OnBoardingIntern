package com.example.onboardinginternapp.data.remote.repository

import androidx.lifecycle.LiveData
import com.example.onboardinginternapp.data.local.db.LocalDaoHelperImpl
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import retrofit2.Call
import retrofit2.Response

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