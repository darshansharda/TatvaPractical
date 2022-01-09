package com.tatvapractical.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val baseUrl = "https://raw.githubusercontent.com/"
    val apiService: ApiService = retrofit().create(ApiService::class.java)
    private fun retrofit() = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

