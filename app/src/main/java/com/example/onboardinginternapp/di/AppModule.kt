package com.example.onboardinginternapp.di

import com.example.onboardinginternapp.data.remote.network.ApiService
import com.example.onboardinginternapp.viewmodel.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { HomeViewModel(get(),get()) }
}
