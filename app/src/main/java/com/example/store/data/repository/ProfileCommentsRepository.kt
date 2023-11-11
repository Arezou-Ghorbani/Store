package com.example.store.data.repository

import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/
class ProfileCommentsRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getProfileComments() = api.getProfileComments()
    suspend fun deleteProfileComment(id: Int) = api.deleteProfileComment(id)
}