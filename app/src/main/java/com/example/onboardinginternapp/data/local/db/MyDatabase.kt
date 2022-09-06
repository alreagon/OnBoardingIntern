package com.example.onboardinginternapp.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onboardinginternapp.data.remote.model.Movie

@Database(
    entities = [Movie::class,
//        MovieDetailResponse::class
               ],
    version = 1)
@TypeConverters(Converters::class)
abstract class MyDatabase: RoomDatabase() {// nyimpen objek kel lokal

    abstract fun localDao(): LocalDao


    companion object {
        @Volatile
        private var instance: MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "article_db.db"
            ).build()
    }

}