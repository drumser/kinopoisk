package ru.quantick.kinopoisk.movie.service.provider

import ru.quantick.kinopoisk.movie.model.Movie

interface MovieProvider {
    fun getTopForTheMonth(): List<Movie>
}
