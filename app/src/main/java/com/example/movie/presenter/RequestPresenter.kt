package com.example.movie.presenter

import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import com.example.movie.view.RequestView
import javax.inject.Inject

class RequestPresenter @Inject constructor() {

    lateinit var movieView: RequestView

    fun attachView(movieView: RequestView) {
        this.movieView = movieView
    }

}