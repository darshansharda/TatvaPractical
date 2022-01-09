package com.tatvapractical.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.tatvapractical.R
import com.tatvapractical.databinding.ActivityViewMovieDetailBinding
import com.tatvapractical.model.MoviesModel

class ViewMovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewMovieDetailBinding
    private lateinit var movieDetail: MoviesModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_movie_detail)
        movieDetail = intent.getSerializableExtra("movieDetail") as MoviesModel
        setMoviesData()
    }

    private fun setMoviesData() {
        binding.apply {
            Glide.with(this@ViewMovieDetailActivity).load(movieDetail.thumb_url).into(ivImage)
            tvName.text = movieDetail.name
            tvDescription.text = movieDetail.desc
            tvRating.text = getString(R.string.rating, movieDetail.rating)
            tvDirector.text = getString(R.string.director, movieDetail.directors.toString().replace("[","").replace("]",""))
            tvStarring.text = getString(R.string.starring, movieDetail.actors.toString().replace("[","").replace("]",""))
            tvGenre.text = getString(R.string.genre, movieDetail.genre.toString().replace("[","").replace("]",""))
        }
    }

}