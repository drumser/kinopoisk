package ru.quantick.kinopoisk.service.movie.provider

import ru.quantick.kinopoisk.model.Movie

interface MovieProvider {
    fun getTopForAMonth(): List<Movie>
}
