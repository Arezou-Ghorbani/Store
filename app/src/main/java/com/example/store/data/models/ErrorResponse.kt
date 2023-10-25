package com.example.store.data.models

import com.google.gson.annotations.SerializedName

/**Created by Arezou-Ghorbani on 25,October,2023,ArezouGhorbaniii@gmail.com**/
data class ErrorResponse(
    @SerializedName("errors")
    val errors: Map<String, List<String>>?,
    @SerializedName("message")
    val message: String? // The given data was invalid.
)