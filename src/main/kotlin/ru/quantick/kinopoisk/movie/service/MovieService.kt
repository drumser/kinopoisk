package ru.quantick.kinopoisk.movie.service

import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.model.MovieStrategy

interface MovieService {
    fun findTopMovies(movieStrategy: MovieStrategy): List<Movie>
}
