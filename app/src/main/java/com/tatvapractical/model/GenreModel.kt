package com.tatvapractical.model

import java.io.Serializable

data class GenreModel(val genre: String = "", val movies: List<MoviesModel> = arrayListOf()) :
    Serializable
