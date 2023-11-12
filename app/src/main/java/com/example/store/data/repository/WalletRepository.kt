package com.example.store.data.repository

import com.example.store.data.models.wallet.BodyIncreaseWallet
import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/
class WalletRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getWallet() = api.getWallet()
    suspend fun postIncreaseWallet(body: BodyIncreaseWallet) = api.postIncreaseWallet(body)
}