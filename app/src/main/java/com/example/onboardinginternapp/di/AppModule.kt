package com.example.onboardinginternapp.di

import com.example.onboardinginternapp.BuildConfig
import com.example.onboardinginternapp.data.remote.network.ApiHelperImpl
import com.example.onboardinginternapp.data.remote.network.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://api.themoviedb.org/3/"

val AppModule = module {

//    single { provideNetworkHelper(androidContext()) }
//    single { provideOkHttpClient() }
//    single { provideRetrofit(get(),"https://api.themoviedb.org/3/") }
//    single { provideApiService(get()) }
    single { ApiHelperImpl(get()) }
    single { provideHTTPLoggingInterceptor() }
    single { provideOkHttpClient() }
    single { provideRetrofit() }


//    single {
//        val loggingInterceptor =
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        val client = OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.themoviedb.org/3/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//        retrofit.create(ApiService::class.java)
//    }}

}

private fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return interceptor;
}

private fun provideOkHttpClient(): OkHttpClient {

    val loggingInterceptor = HttpLoggingInterceptor()
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(AuthInterceptor(BuildConfig.API_KEY))
        .build()
}

private fun provideRetrofit(): Retrofit {
    val okHttpClient =  OkHttpClient()
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}


//private fun provideNetworkHelper(context: Context) = NetworkHelper(context)
//
//private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
//    val loggingInterceptor = HttpLoggingInterceptor()
//    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//    OkHttpClient.Builder()
//        .connectTimeout(1, TimeUnit.MINUTES)
//        .writeTimeout(1, TimeUnit.MINUTES)
//        .readTimeout(1, TimeUnit.MINUTES)
//        .addInterceptor(loggingInterceptor)
//        .build()
//} else OkHttpClient
//    .Builder()
//    .connectTimeout(1, TimeUnit.MINUTES)
//    .writeTimeout(1, TimeUnit.MINUTES)
//    .readTimeout(1, TimeUnit.MINUTES)
//    .build()
//
//private fun provideRetrofit (
//    okHttpClient: OkHttpClient,
//    BASE_URl: String
//) : Retrofit =
//    Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(BASE_URl)
//        .client(okHttpClient)
//        .build()
//
//private fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)