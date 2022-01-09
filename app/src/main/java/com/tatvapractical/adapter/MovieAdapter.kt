package com.tatvapractical.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tatvapractical.R
import com.tatvapractical.databinding.RowMovieBinding
import com.tatvapractical.model.MoviesModel
import com.tatvapractical.ui.ViewMovieDetailActivity

class MovieAdapter(private val context: Context, private val moviesList: List<MoviesModel>) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: RowMovieBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieHolder(LayoutInflater.from(context).inflate(R.layout.row_movie, parent, false))

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.binding.apply {
            tvName.text = moviesList[position].name
            Glide.with(context).load(moviesList[position].thumb_url).into(ivImage)
        }

        holder.itemView.setOnClickListener {
            context.startActivity(
                Intent(
                    context,
                    ViewMovieDetailActivity::class.java
                ).putExtra("movieDetail", moviesList[holder.adapterPosition])
            )
        }

    }

    override fun getItemCount() = moviesList.size

}