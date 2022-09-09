package com.example.onboardinginternapp.data.local.db

import androidx.lifecycle.LiveData
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import retrofit2.Call
import retrofit2.Response


class LocalDaoHelperImpl(private val localDao: LocalDao) {

    fun getAllMovies() = localDao.getAllMovies()

    suspend fun deleteAndInsertData(moviess: List<Movie>) {
        localDao.deleteAllMovies()
        moviess.forEach { movie ->
            localDao.insertMovie(movie)
        }
    }


//    suspend fun deleteAndInsertData(moviess: List<Movie>) = localDao.deleteAndInsertData(moviess)

//    fun getDetailMovies() = localDao.getDetailMovies()
//    suspend fun deleteAndInsertDataDetail(detailmoviess : MovieDetailResponse?) = localDao.deleteAndInsertDataDetail(detailmoviess)


}