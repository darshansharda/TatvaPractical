package com.tatvapractical.api

import com.tatvapractical.model.MoviesModel
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovieData(): List<MoviesModel>
}