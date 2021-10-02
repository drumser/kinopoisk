package ru.quantick.kinopoisk.movie.service.strategy

import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.model.MovieStrategy

interface TopMovieStrategy {
    fun findTop(): List<Movie>
    fun supports(movieStrategy: MovieStrategy): Boolean
}
