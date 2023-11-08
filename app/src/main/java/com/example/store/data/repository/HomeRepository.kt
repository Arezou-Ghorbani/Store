package com.example.store.data.repository

import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 05,November,2023,ArezouGhorbaniii@gmail**/
class HomeRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getBannersList(slug: String) = api.getBannersList(slug)
    suspend fun getDiscountList(slug: String) = api.getDiscountList(slug)
    suspend fun getProductsList(slug: String, queries: Map<String, String>) = api.getProductsList(slug, queries)
}