package com.example.store.data.repository

import com.example.store.data.models.address.BodySubmitAddress
import com.example.store.data.network.ApiServices
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/
class ProfileAddressRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getProfileAddressesList() = api.getProfileAddressesList()
    suspend fun getProvinceList() = api.getProvinceList()
    suspend fun getCityList(id: Int) = api.getCityList(id)
    suspend fun postSubmitAddress(body: BodySubmitAddress) = api.postSubmitAddress(body)
    suspend fun deleteProfileAddress(id: Int) = api.deleteProfileAddress(id)
}