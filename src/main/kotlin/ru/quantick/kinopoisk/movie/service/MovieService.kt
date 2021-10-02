package ru.quantick.kinopoisk.movie.service

import ru.quantick.kinopoisk.movie.model.Movie

interface MovieService {
    fun getTopMoviesForTheMonth(): List<Movie>
}
