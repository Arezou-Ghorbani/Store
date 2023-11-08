package com.example.store.data.repository

import com.example.store.data.models.profile.BodyUpdateProfile
import com.example.store.data.network.ApiServices
import okhttp3.RequestBody
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 05,November,2023,ArezouGhorbaniii@gmail**/
class ProfileRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getProfileData() = api.getProfileData()
    suspend fun postUploadAvatar(body: RequestBody) = api.postUploadAvatar(body)
    suspend fun postUploadProfile(body: BodyUpdateProfile) = api.postUploadProfile(body)
}