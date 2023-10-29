package com.example.store.data.models

import com.google.gson.annotations.SerializedName

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
data class SimpleResponse(
    @SerializedName("message")
    val message: String? // با موفقیت به سبد خرید اضافه شد.
)