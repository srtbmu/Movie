package com.example.movie

import android.app.Application
import com.example.movie.model.MovieApi
import dagger.Module
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@HiltAndroidApp
class App : Application() {

}