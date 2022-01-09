package com.tatvapractical.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val baseUrl = "https://raw.githubusercontent.com/"
    val apiService = retrofit().create(ApiService::class.java)
    private fun retrofit(): Retrofit {
        val inter = HttpLoggingInterceptor()
        inter.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder().addInterceptor(inter)
        return Retrofit.Builder().baseUrl(baseUrl).client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}