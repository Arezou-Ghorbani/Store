package com.example.store.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.models.categories.ResponseCategories
import com.example.store.data.repository.CategoriesRepository
import com.example.store.utils.base.BaseFragment
import com.example.store.utils.network.NetworkRequest
import com.example.store.utils.network.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: CategoriesRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(300)
            callCategoriesApi()
        }
    }

    //Categories
    private val _categoriesData = MutableLiveData<NetworkRequest<ResponseCategories>>()
    val categoriesData: LiveData<NetworkRequest<ResponseCategories>> = _categoriesData

    private fun callCategoriesApi() = viewModelScope.launch {
        _categoriesData.value = NetworkRequest.Loading()
        val response = repository.getCategoriesList()
        _categoriesData.value = NetworkResponse(response).generateResponse()
    }
}
