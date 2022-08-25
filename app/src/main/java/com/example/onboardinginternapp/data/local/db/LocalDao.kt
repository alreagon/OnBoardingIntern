package com.example.onboardinginternapp.data.local.db

import androidx.room.*
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import retrofit2.Response

@Dao
interface LocalDao {

    //All movie
    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(moviess: List<Movie>)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()

    @Transaction
    suspend fun deleteAndInsertData(moviesss: List<Movie>) {
        deleteAllMovies()
        insertMovie(moviesss)
    }

    //Detail movie
    @Query("SELECT * FROM detailMovies")
    fun getDetailMovies(): Response<MovieDetailResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailMovie(detailmoviess: Response<MovieDetailResponse>)

    @Query("DELETE FROM detailMovies")
    suspend fun deleteDetailMovies()

    @Transaction
    suspend fun deleteAndInsertDataDetail(detailmoviess: Response<MovieDetailResponse>) {
        deleteDetailMovies()
        insertDetailMovie(detailmoviess)
    }

}