package com.tatvapractical.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatvapractical.api.ApiHelper
import com.tatvapractical.api.ApiHelperImpl
import com.tatvapractical.api.Resource
import com.tatvapractical.api.RetrofitBuilder
import com.tatvapractical.model.MoviesModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val apiHelper: ApiHelper = ApiHelperImpl(RetrofitBuilder.apiService)
    private val moviesList = MutableLiveData<Resource<List<MoviesModel>>>()

    fun getMovieList(): LiveData<Resource<List<MoviesModel>>> = moviesList

    init {
        getMoviesData()
    }

    private fun getMoviesData() {

        viewModelScope.launch {
            moviesList.postValue(Resource.loading())
            try {
                val response = apiHelper.getMovieData()
                moviesList.postValue(Resource.success(response))
            } catch (e: Exception) {
                moviesList.postValue(
                    Resource.error(
                        null,
                        "Server error,Please try after some time"
                    )
                )
            }
        }


    }

}