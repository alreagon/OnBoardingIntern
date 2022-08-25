package com.example.onboardinginternapp.data.remote.repository

import com.example.onboardinginternapp.data.local.db.LocalDaoHelperImpl
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.data.remote.network.ApiHelperImpl
import retrofit2.Response

class RemoteRepository(
    private val apiHelperImpl: ApiHelperImpl,
    private val localDaoHelperImpl: LocalDaoHelperImpl
) {

    suspend fun getMovieBoundResource(params: HashMap<String,String>): List<Movie> {
        val response = apiHelperImpl.getMovieBoundResource(params)
        localDaoHelperImpl.deleteAndInsertData(response.take(40))
        return response
    }

    fun getMovieOffline(): List<Movie> {
        return localDaoHelperImpl.getAllMovies()
    }

    suspend fun getDetailMovieBuondResource(id :Int) : Response<MovieDetailResponse>{
        val response = apiHelperImpl.getDetailBoundResource(id)
        localDaoHelperImpl.deleteAndInsertDataDetail(response)
        return response
    }
    fun getDetailMovieOffline(): Response<MovieDetailResponse>{
        return localDaoHelperImpl.getDetailMovies()
    }



}