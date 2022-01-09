package com.tatvapractical.model

import java.io.Serializable

data class MoviesModel(
    val genre: List<String>,
    val actors: List<String>,
    val directors: List<String>,
    val desc: String,
    val name: String,
    val rating: String,
    val year: String,
    val image_url: String,
    val thumb_url: String,
    val imdb_url: String
) : Serializable
