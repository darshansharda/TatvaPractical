package com.tatvapractical.api

import com.tatvapractical.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("theapache64/top250/master/top250_min.json")
    suspend fun getMovieData(): List<MoviesModel>
}