package com.example.onboardinginternapp.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.onboardinginternapp.model.Movie
import com.example.onboardinginternapp.model.MovieResponse
import com.example.onboardinginternapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Response

class HomeViewModel: ViewModel() {


    private val _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        const val TAG = "MainViewModel"
        const val API_KEY = "1c9c88a7ed857e63d5aaab264c8d0169"
    }

    init {
        fetchData()
    }


    private fun fetchData() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getMovie(API_KEY)
        client.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading.value = false
                    _movie.value = response.body()?.results
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}

