package ru.quantick.kinopoisk.movie.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.quantick.kinopoisk.movie.model.MovieStrategy
import ru.quantick.kinopoisk.movie.model.MoviesResponse
import ru.quantick.kinopoisk.movie.model.toResponse
import ru.quantick.kinopoisk.movie.service.MovieService


@RestController
class TopMovieController(val movieService: MovieService) {
    @GetMapping("/movies/top")
    fun getTop(
        @RequestParam(name = "type")
        movieStrategy: MovieStrategy
    ): MoviesResponse =
        movieService
            .findTopMovies(movieStrategy)
            .toResponse()
}

