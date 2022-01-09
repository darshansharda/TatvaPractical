package com.tatvapractical.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tatvapractical.R
import com.tatvapractical.api.Status
import com.tatvapractical.databinding.ActivityMainBinding
import com.tatvapractical.model.GenreModel
import com.tatvapractical.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private val genre = HashSet<String>()
    private val genreList = arrayListOf<GenreModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setObserver()
    }

    private fun setObserver() {
        homeViewModel.getMovieList().observe(this) {
            when (it.status) {

                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                }

                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    for (i in it.data?.indices!!) {
                        for (j in it.data[i].genre.indices) {
                            genre.add(it.data[i].genre[j])
                        }
                    }

                    for (i in 0 until genre.size) {
                        val model = GenreModel(genre = genre.elementAt(i))
                        genreList.add(model)
                    }

                }

                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()

                }


            }
        }
    }

}