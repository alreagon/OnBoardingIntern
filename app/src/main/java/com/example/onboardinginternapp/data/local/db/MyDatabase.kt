package com.example.onboardinginternapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieDetailResponse
import com.example.onboardinginternapp.data.remote.model.MovieDetailTypeConverter
import com.example.onboardinginternapp.data.remote.model.MovieTypeConverter

@Database(entities = [Movie::class, MovieDetailResponse::class ], version = 1)
@TypeConverters(MovieDetailTypeConverter::class, MovieTypeConverter::class)
abstract class MyDatabase: RoomDatabase() {// nyimpen objek kel lokal
    abstract fun localDao(): LocalDao
}