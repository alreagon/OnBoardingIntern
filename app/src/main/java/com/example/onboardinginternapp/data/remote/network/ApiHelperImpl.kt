package com.example.onboardinginternapp.data.remote.network

import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.utils.ErrorUtils
import com.example.onboardinginternapp.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit


class ApiHelperImpl(private val retrofit: Retrofit) {

    suspend fun getMovieRemake(): Resource<MovieResponse> {
        val moviePop = retrofit.create(ApiService::class.java)
        return getResponse(
            request = { moviePop.getMovieRemake() },
            defaultErrorMessage = "Error fatching movie list"
        )
    }

    private suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Resource<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val resource = request.invoke()
            if (resource.isSuccessful) {
                return Resource.success(resource.body())
            } else {
                val errorResponse = ErrorUtils.parseError(resource, retrofit)
                Resource.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Resource.error("Unknown Error", null)
        }
    }
//    suspend fun getMovieBoundResource(parameters: String) : List<MovieResponse> {
//        return apiService.getMovieBoundResource(parameters)
//    }

//    suspend fun getDetailBoundResource(id : Int) : Response<MovieDetailResponse>{
//        return apiService.getDetailMovePopularId(id)
//    }

}