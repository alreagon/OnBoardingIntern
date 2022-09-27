package com.example.onboardinginternapp.data.local.db

import androidx.room.*
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse

@Dao
interface LocalDao {

//    //All movie Response
//    @Query("SELECT * FROM moviesResponse")
//    fun getAllMoviesResponse(): List<MovieResponse>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertMovieResponse(moviesResponse: MovieResponse)
//
//    @Query("DELETE FROM moviesResponse")
//    suspend fun deleteAllMoviesResponse()
//
//    @Transaction
//    suspend fun deleteAndInsertData(moviesResponse: MovieResponse) {
//        deleteAllMoviesResponse()
//        insertMovieResponse(moviesResponse)
//    }

    //All movie
//    @Query("SELECT * FROM movies")
//    fun getAllMovies(): List<Movie>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertMovie(moviess: Movie)
//
//    @Query("DELETE FROM movies")
//    suspend fun deleteAllMovies()
//
//    @Transaction
//    suspend fun deleteAndInsertData(moviesss: List<Movie>) {
//        deleteAllMovies()
//    }

    //Detail movie
//    @Query("SELECT * FROM detailMovies")
//    fun getDetailMovies(): List<MovieDetailResponse>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertDetailMovie(detailmoviess: MovieDetailResponse?)
//
//    @Query("DELETE FROM detailMovies")
//    suspend fun deleteDetailMovies()
//
//    @Transaction
//    suspend fun deleteAndInsertDataDetail(detailmoviess: MovieDetailResponse?) {
//        deleteDetailMovies()
//        insertDetailMovie(detailmoviess)
//    }

}