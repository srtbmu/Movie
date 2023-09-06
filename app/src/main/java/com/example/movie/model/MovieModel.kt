package com.example.movie.model

data class MovieModel(
    var Title: String,
    var Year: String,
    var Genre: String,
    var Awards: String,
    var Poster: String,

    var Director:String,

    var Ratings: ArrayList<RatingModel>,
)

data class RatingModel(
    var Value: String,
    var Source: String
)