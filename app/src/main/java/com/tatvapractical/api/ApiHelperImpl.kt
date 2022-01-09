package com.tatvapractical.api

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getMovieData() = apiService.getMovieData()
}