package com.example.store.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.models.categories.FilterCategoryModel
import com.example.store.data.models.home.ResponseProducts
import com.example.store.data.models.search_filter.FilterModel
import com.example.store.data.repository.CategoryProductRepository
import com.example.store.data.repository.SearchFilterRepository
import com.example.store.utils.MAX_PRICE
import com.example.store.utils.MIN_PRICE
import com.example.store.utils.ONLY_AVAILABLE
import com.example.store.utils.SEARCH
import com.example.store.utils.SELECTED_BRANDS
import com.example.store.utils.SORT
import com.example.store.utils.network.NetworkRequest
import com.example.store.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/
@HiltViewModel
class CategoryProductViewModel @Inject constructor(
    private val repository: CategoryProductRepository, private val filterRepository: SearchFilterRepository
) : ViewModel() {
    //Products
    fun productsQueries(
        sort: String? = null, search: String? = null, minPrice: String? = null, maxPrice: String? = null,
        brands: String? = null, available: Boolean? = null
    ): Map<String, String> {

        val queries: HashMap<String, String> = HashMap()
        if (sort != null)
            queries[SORT] = sort
        if (search != null)
            queries[SEARCH] = search
        if (minPrice != null)
            queries[MIN_PRICE] = minPrice
        if (maxPrice != null)
            queries[MAX_PRICE] = maxPrice
        if (brands != null)
            queries[SELECTED_BRANDS] = brands
        if (available != null)
            queries[ONLY_AVAILABLE] = available.toString()
        return queries
    }

    private val _productData = MutableLiveData<NetworkRequest<ResponseProducts>>()
    val productData: LiveData<NetworkRequest<ResponseProducts>> = _productData

    fun callProductsApi(slug: String, queries: Map<String, String>) = viewModelScope.launch {
        _productData.value = NetworkRequest.Loading()
        val response = repository.getProductsList(slug, queries)
        _productData.value = NetworkResponse(response).generateResponse()
    }

    //Sorts list
    private val _filterData = MutableLiveData<MutableList<FilterModel>>()
    val filterData: LiveData<MutableList<FilterModel>> = _filterData

    fun getFilterData() = viewModelScope.launch {
        _filterData.value = filterRepository.fillFilterData()
    }

    //Filter Data
    private val _filterCategoryData = MutableLiveData<FilterCategoryModel>()
    val filterCategoryData: LiveData<FilterCategoryModel> = _filterCategoryData

    fun sendCategoryData(

        sort: String? = null, search: String? = null, minPrice: String? = null, maxPrice: String? = null,
        available: Boolean? = null
    ) {
        _filterCategoryData.value = FilterCategoryModel(sort, search, minPrice, maxPrice, available)
    }
}