package com.example.store.data.repository

import com.example.store.data.models.cart.BodyAddToCart
import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
class CartRepository @Inject constructor(private val api: ApiServices) {
    suspend fun postAddToCart(id: Int, body: BodyAddToCart) = api.postAddToCart(id, body)
    suspend fun getCartList() = api.getCartList()


}