package com.example.store.data.repository

import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/
class ProfileOrdersRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getProfileOrdersList(status: String) = api.getProfileOrdersList(status)
}