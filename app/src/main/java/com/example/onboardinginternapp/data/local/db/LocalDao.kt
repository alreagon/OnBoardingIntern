package com.example.onboardinginternapp.data.local.db

import androidx.room.*
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse

@Dao
interface LocalDao {

    @Query("SELECT * FROM movies order by popularity DESC")
    fun getAllMovies(): List<Movie>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(moviess: List<Movie>)

    @Delete
    fun delete(movie: Movie)

    @Delete
    fun deleteAll(movie: List<Movie>)

//    @Query("DELETE FROM movies")
//    suspend fun deleteAllMovies()
//
//    @Transaction
//    suspend fun deleteAndInsertData(moviesss: List<Movie>) {
//        deleteAllMovies()
//}
    }

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

