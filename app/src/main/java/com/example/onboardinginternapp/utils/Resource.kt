package com.example.onboardinginternapp.utils

import com.example.onboardinginternapp.data.remote.model.Error

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val error: Error?,
    val message: String?
) {
    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, error: Error?): Resource<T> {
            return Resource(Status.ERROR, null, error, msg)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }

    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}
