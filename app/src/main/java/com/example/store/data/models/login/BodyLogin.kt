package com.example.store.data.models.login

import com.google.gson.annotations.SerializedName

/**Created by Arezou-Ghorbani on 21,October,2023,ArezouGhorbaniii@gmail.com**/
data class BodyLogin(
    @SerializedName("login")
    var login: String? = null, // 09120174757
    @SerializedName("hash_code")
    var hashCode: String? = null, // dfUYjdf84
    @SerializedName("code")
    var code: Int? = null // 8456
)