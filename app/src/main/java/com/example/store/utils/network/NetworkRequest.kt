package com.example.store.utils.network

/**Created by Arezou-Ghorbani on 25,October,2023,ArezouGhorbaniii@gmail.com**/
sealed class NetworkRequest<T>(val data: T? = null, val error: String? = null) {
    class Loading<T> : NetworkRequest<T>()
    class Success<T>(data: T) : NetworkRequest<T>(data)
    class Error<T>(message: String) : NetworkRequest<T>(error = message)
}