package com.tatvapractical.model

data class MoviesModel(
    val genre: List<String>,
    val actors: List<String>,
    val directors: List<String>,
    val desc: String,
    val name: String,
    val rating: String,
    val year: String,
    val image_url: String,
    val thumb_url: String
)
