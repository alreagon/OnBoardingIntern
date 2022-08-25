package com.example.onboardinginternapp.data.local.db

import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import retrofit2.Response


class LocalDaoHelperImpl(private val localDao: LocalDao) {

    fun getAllMovies() = localDao.getAllMovies()
    suspend fun deleteAndInsertData(moviess: List<Movie>) = localDao.deleteAndInsertData(moviess)

    fun getDetailMovies() = localDao.getDetailMovies()
    suspend fun deleteAndInsertDataDetail(detailmoviess : Response<MovieDetailResponse>) = localDao.deleteAndInsertDataDetail(detailmoviess)


}