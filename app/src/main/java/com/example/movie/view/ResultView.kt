package com.example.movie.view

import com.example.movie.model.MovieModel

interface ResultView {

    fun showMovie(movieModel: MovieModel)

    fun showError(message: String)

}