package ru.quantick.kinopoisk.movie.model

data class Movie(
    val id: String,
    val title: String,
    val genres: List<String>?,
    val posterUrl: String?,
    val years: String?
)

data class MovieResponse(
    val id: String,
    val title: String,
    val genres: List<String>?,
    val posterUrl: String?,
    val years: String?
)

fun Movie.toResponse() = MovieResponse(
    id = this.id,
    title = this.title,
    genres = this.genres,
    posterUrl = this.posterUrl,
    years = this.years
)
