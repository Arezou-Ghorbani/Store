package com.example.store.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.models.login.BodyLogin
import com.example.store.data.models.login.ResponseLogin
import com.example.store.data.repository.LoginRepository
import com.example.store.utils.network.NetworkRequest
import com.example.store.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 26,October,2023,ArezouGhorbaniii@gmail.com**/
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {
    //Login
    private val _loginData = MutableLiveData<NetworkRequest<ResponseLogin>>()
    val loginData: LiveData<NetworkRequest<ResponseLogin>> = _loginData

    fun callLoginApi(body: BodyLogin) = viewModelScope.launch {
        _loginData.value = NetworkRequest.Loading()
        val response = repository.postLogin(body)
        _loginData.value = NetworkResponse(response).generateResponse()
    }
}