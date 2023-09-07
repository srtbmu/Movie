package com.example.movie.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movie.databinding.FragmentResultBinding
import com.example.movie.model.MovieModel
import com.example.movie.presenter.ResultPresenter
import com.example.movie.view.ResultView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment : Fragment(), ResultView {

    @Inject
    lateinit var presenter: ResultPresenter

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        setData()
    }

    private fun setData() {
        val text = arguments?.getString("key_search")
        presenter.getMovieDetails(text.toString())
    }

    override fun showMovie(movieModel: MovieModel) {
        binding.tvTitle.text = movieModel.Title
        binding.tvYear.text = movieModel.Year
        binding.tvGenre.text = movieModel.Genre
        binding.tvAwards.text = movieModel.Awards
        binding.tvDirector.text = movieModel.Director
        binding.tvWriter.text = movieModel.Writer
        binding.tvLanguage.text = movieModel.Language
        binding.tvCountry.text = movieModel.Country
        Glide.with(binding.imgPoster).load(movieModel.Poster).into(binding.imgPoster)
        Log.e("ololo", "showMovie:$movieModel ")
    }

    override fun showError(message: String) {
        Log.e("ololo", "showError: ${message}")
        Toast.makeText(requireActivity(), "Error sevice", Toast.LENGTH_SHORT).show()
    }
}