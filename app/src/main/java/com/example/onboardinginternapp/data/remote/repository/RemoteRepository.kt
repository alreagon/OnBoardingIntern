package com.example.onboardinginternapp.data.remote.repository

import com.example.onboardinginternapp.data.local.db.LocalDao
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.data.remote.network.ApiHelperImpl
import com.example.onboardinginternapp.utils.Resource
import com.example.onboardinginternapp.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


@Suppress("UNCHECKED_CAST")
class RemoteRepository(
    private val apiHelperImpl: ApiHelperImpl,
    private val localDao: LocalDao
) {

    suspend fun fetchPopMovies(): Flow<Resource<MovieResponse>?> {
        return flow {
            emit(fetchPopMoviesCached())
            emit(Resource.loading(null))
            val resource = apiHelperImpl.getMovieRemake()

            //Cache to database if response is successful
            if (resource.status == Status.SUCCESS) {
                resource.data?.results?.let { it ->
                    localDao.deleteAll(it)
                    localDao.insertMovie(it)
                }
            }
            emit(resource)
        }.flowOn(Dispatchers.IO) as Flow<Resource<MovieResponse>?>
    }

    private fun fetchPopMoviesCached(): Result<MovieResponse>? =
        localDao.getAllMovies()?.let {
            Result.success(MovieResponse(it))
        }


}

//class RemoteRepository(
//    private val apiHelperImpl: ApiHelperImpl,
//    private val localDaoHelperImpl: LocalDaoHelperImpl
//) {
//
//    suspend fun getMovieBoundResource(params: String): List<Movie> {
//        val response = apiHelperImpl.getMovieBoundResource(params)
//        localDaoHelperImpl.deleteAndInsertData(response)
//        return response
//    }
//
//    fun getMovieOffline(): List<Movie> {
//        return localDaoHelperImpl.getAllMovies()
//    }
//
////    suspend fun getDetailMovieBuondResource(id :Int) : MovieDetailResponse?{
////        val response = apiHelperImpl.getDetailBoundResource(id)
////        localDaoHelperImpl.deleteAndInsertDataDetail(response.body())
////        return response
////    }
////    fun getDetailMovieOffline(): List<MovieDetailResponse>{
////        return localDaoHelperImpl.getDetailMovies()
////    }
//
//
//
