package ru.quantick.kinopoisk.movie.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.quantick.kinopoisk.movie.model.TopMovieResponse
import ru.quantick.kinopoisk.movie.model.toResponse
import ru.quantick.kinopoisk.movie.service.MovieService


@RestController
class MovieController(val movieService: MovieService) {
    @GetMapping("/movies/top")
    fun getTop(): TopMovieResponse =
        movieService
            .findTopMoviesForTheMonth()
            .toResponse()
}

