package com.example.store.data.models.cart

import com.google.gson.annotations.SerializedName

data class BodyAddToCart(
    @SerializedName("colorId")
    var colorId: String? = null // 2
)