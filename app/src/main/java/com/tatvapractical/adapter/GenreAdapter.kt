package com.tatvapractical.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatvapractical.R
import com.tatvapractical.databinding.RowGenreBinding
import com.tatvapractical.model.GenreModel

class GenreAdapter(private val context: Context, private val genreList: List<GenreModel>) :
    RecyclerView.Adapter<GenreAdapter.GenreHolder>() {

    class GenreHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: RowGenreBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GenreHolder(
        LayoutInflater.from(context).inflate(R.layout.row_genre, parent, false)
    )

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.binding.apply {
            tvGenre.text = genreList[position].genre
            rvMovies.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvMovies.adapter = MovieAdapter(context, genreList[position].movies)
        }
    }

    override fun getItemCount() = genreList.size

}