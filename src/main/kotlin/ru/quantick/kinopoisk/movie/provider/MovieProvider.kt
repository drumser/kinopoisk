package ru.quantick.kinopoisk.movie.provider

import ru.quantick.kinopoisk.movie.model.Movie

interface MovieProvider {
    fun findTopForTheMonth(): List<Movie>
}
