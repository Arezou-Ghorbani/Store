package com.example.store.data.network

import com.example.store.data.models.SimpleResponse
import com.example.store.data.models.cart.BodyAddToCart
import com.example.store.data.models.cart.ResponseCartList
import com.example.store.data.models.login.BodyLogin
import com.example.store.data.models.login.ResponseLogin
import com.example.store.data.models.login.ResponseVerify
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**Created by Arezou-Ghorbani on 21,October,2023,ArezouGhorbaniii@gmail.com**/
interface ApiServices {
    @POST("auth/login")
    suspend fun postLogin(@Body body: BodyLogin): Response<ResponseLogin>
    @POST("auth/login/verify")
    suspend fun postVerify(@Body body: BodyLogin): Response<ResponseVerify>
    @POST("product/{id}/add_to_cart")
    suspend fun postAddToCart(@Path("id") id: Int, @Body body: BodyAddToCart): Response<SimpleResponse>

    @GET("cart")
    suspend fun getCartList(): Response<ResponseCartList>
}