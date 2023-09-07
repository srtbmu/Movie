package com.example.movie.model


//{
//    "Rated": "N/A",
//    "Runtime": "N/A",
//    "Writer": "Oleksandr Anpilohov",
//    "Actors": "N/A",
//    "Plot": "N/A",
//    "Ratings": [],
//    "Metascore": "N/A",
//    "imdbRating": "N/A",
//    "imdbVotes": "N/A",
//    "imdbID": "tt5883812",
//    "Type": "movie",
//    "DVD": "N/A",
//    "BoxOffice": "N/A",
//    "Production": "N/A",
//    "Website": "N/A",
//    "Response": "True"
//}
data class MovieModel(
    var Poster: String,
    var Title: String,
    var Year: String,
    var Genre: String,
    var Awards: String,
    var Director: String,

    var Writer: String,
    var Language: String,
    var Country: String,
    var Ratings: ArrayList<RatingModel>,
)

data class RatingModel(
    var Value: String,
    var Source: String
)