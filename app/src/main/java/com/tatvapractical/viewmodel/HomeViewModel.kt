package com.tatvapractical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tatvapractical.api.ApiHelperImpl
import com.tatvapractical.api.Resource
import com.tatvapractical.api.RetrofitBuilder
import com.tatvapractical.model.MoviesModel
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)

    private val moviesList = MutableLiveData<Resource<List<MoviesModel>>>()

    private fun getMoviesData() {


    }

}