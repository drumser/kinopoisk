package ru.quantick.kinopoisk.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.quantick.kinopoisk.model.MovieResponse
import ru.quantick.kinopoisk.model.toResponse
import ru.quantick.kinopoisk.service.movie.MovieService

data class TopMovieResponse(
    val movies: List<MovieResponse>
)

@RestController
class MovieController(val movieService: MovieService) {
    @GetMapping("/movies/top")
    fun getTop(): TopMovieResponse =
        movieService
            .getTopMoviesForTheMonth()
            .map { it.toResponse() }
            .let {
                TopMovieResponse(
                    movies = it
                )
            }
}

