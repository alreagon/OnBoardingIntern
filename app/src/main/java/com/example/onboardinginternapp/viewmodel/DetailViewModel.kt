package com.example.onboardinginternapp.viewmodel

//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.onboardinginternapp.data.remote.repository.RemoteRepository
//import com.example.onboardinginternapp.utils.NetworkHelper
//import com.example.onboardinginternapp.utils.Resource
//import kotlinx.coroutines.launch

//class DetailViewModel(
//    private val remoteRepository: RemoteRepository,
//    private val networkHelper: NetworkHelper
//) : ViewModel() {
//
//    private val _getDetailMovie = MutableLiveData<Resource<MovieDetailResponse>>()
//    val getDetailMovie: LiveData<Resource<MovieDetailResponse>>
//        get() = _getDetailMovie
//
//    fun DetailMovie(detailId: Int) {
//        viewModelScope.launch {
//            if (networkHelper.isNetworkConnected()) {
//                try {
//                    val movieId = remoteRepository.getDetailMovieBuondResource(detailId)
//                    if (movieId.isSuccessful) {
//                        _getDetailMovie.postValue(Resource.success(movieId.body()))
//                    } else {
//                        _getDetailMovie.postValue(
//                            Resource.error(
//                                "Failed to get detail product",
//                                null
//                            )
//                        )
//                    }
//                } catch (e: Exception) {
//                    _getDetailMovie.postValue(Resource.error(e.message.toString(), null))
//                }
//            } else {
//
//                val response = remoteRepository.getDetailMovieOffline()
//                _getDetailMovie.postValue(Resource.error(response))
//                _getDetailMovie.postValue(
//                    Resource.error(
//                        "please check your internet connection...",
//                        null
//                    )
//                )
//            }
//        }
//    }
//}
