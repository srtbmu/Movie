package com.example.movie.presenter

import android.widget.Toast
import com.example.movie.model.MovieApi
import com.example.movie.model.MovieModel
import com.example.movie.view.ResultView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ResultPresenter @Inject constructor(private val movieApi: MovieApi) {

    lateinit var resultView: ResultView

    fun getMovieDetails(name: String) {
        movieApi.getMovie(name).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                response.body()?.let {
                    resultView.showMovie(it)
                }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                resultView.showError(t.message.toString())
            }
        })
    }

    fun attachView(resultView: ResultView) {
        this.resultView = resultView
    }

}