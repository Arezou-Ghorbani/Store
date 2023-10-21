package com.example.store.data.models.login

import com.google.gson.annotations.SerializedName

/**Created by Arezou-Ghorbani on 21,October,2023,ArezouGhorbaniii@gmail.com**/
data class ResponseLogin(
    @SerializedName("ex")
    val ex: Int?, // 3
    @SerializedName("isEmail")
    val isEmail: Int?, // 0
    @SerializedName("time")
    val time: Int? // 90
)