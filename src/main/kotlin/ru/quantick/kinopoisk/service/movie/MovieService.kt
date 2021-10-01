package ru.quantick.kinopoisk.service.movie

import ru.quantick.kinopoisk.model.Movie

interface MovieService {
    fun getTopMoviesForTheMonth(): List<Movie>
}
