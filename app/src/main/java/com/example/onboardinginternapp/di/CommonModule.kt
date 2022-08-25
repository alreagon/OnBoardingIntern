package com.example.onboardinginternapp.di

import android.content.Context
import androidx.room.Room
import com.example.onboardinginternapp.data.local.db.LocalDao
import com.example.onboardinginternapp.data.local.db.LocalDaoHelperImpl
import com.example.onboardinginternapp.data.local.db.MyDatabase
import com.example.onboardinginternapp.data.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(ApiService::class.java)
    }
}
val localDbModule = module {
    single { provideDb(androidContext()) }
    single { provideProductDao(get()) }
    single { provideProductDaoImpl(get()) }
}

private fun provideDb(context: Context) : MyDatabase {
    return Room.databaseBuilder(context,MyDatabase::class.java,"my_db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}

private fun provideProductDao(myDatabase: MyDatabase): LocalDao {
    return myDatabase.localDao()
}

private fun provideProductDaoImpl(localDao: LocalDao): LocalDaoHelperImpl {
    return LocalDaoHelperImpl(localDao)
}


