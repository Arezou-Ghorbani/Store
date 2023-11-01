package com.example.store.data.models.cart

import com.google.gson.annotations.SerializedName

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
data class BodyAddToCart(
    @SerializedName("colorId")
    var colorId: String? = null // 2
)