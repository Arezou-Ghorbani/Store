package com.example.store.data.network

import com.example.store.data.models.login.BodyLogin
import com.example.store.data.models.login.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**Created by Arezou-Ghorbani on 21,October,2023,ArezouGhorbaniii@gmail.com**/
interface ApiServices {
    @POST("auth/login")
    suspend fun postLogin(@Body body: BodyLogin): Response<ResponseLogin>
    315 min 11
}