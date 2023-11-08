package com.example.store.data.network

import com.example.store.data.models.SimpleResponse
import com.example.store.data.models.cart.BodyAddToCart
import com.example.store.data.models.cart.ResponseCartList
import com.example.store.data.models.home.ResponseBanners
import com.example.store.data.models.home.ResponseDiscount
import com.example.store.data.models.home.ResponseProducts
import com.example.store.data.models.login.BodyLogin
import com.example.store.data.models.login.ResponseLogin
import com.example.store.data.models.login.ResponseVerify
import com.example.store.data.models.profile.BodyUpdateProfile
import com.example.store.data.models.profile.ResponseProfile
import com.example.store.data.models.search.ResponseSearch
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

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
    @GET("ad/swiper/{slug}")
    suspend fun getBannersList(@Path("slug") slug: String): Response<ResponseBanners>

    @GET("offers/discount/{slug}")
    suspend fun getDiscountList(@Path("slug") slug: String): Response<ResponseDiscount>

    @GET("category/pro/{slug}")
    suspend fun getProductsList(@Path("slug") slug: String, @QueryMap queries: Map<String, String>): Response<ResponseProducts>

    @GET("search")
    suspend fun getSearchList(@QueryMap queries: Map<String, String>): Response<ResponseSearch>
    @GET("auth/detail")
    suspend fun getProfileData(): Response<ResponseProfile>
    @POST("auth/avatar")
    suspend fun postUploadAvatar(@Body body: RequestBody): Response<Unit>

    @PUT("auth/update")
    suspend fun postUploadProfile(@Body body: BodyUpdateProfile): Response<ResponseProfile>

}