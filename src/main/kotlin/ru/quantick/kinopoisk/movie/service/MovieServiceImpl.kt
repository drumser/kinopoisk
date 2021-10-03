package ru.quantick.kinopoisk.movie.service

import mu.KLogging
import org.springframework.stereotype.Service
import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.model.MovieStrategy
import ru.quantick.kinopoisk.movie.service.strategy.TopMovieStrategy

@Service
class MovieServiceImpl(val movieStrategies: List<TopMovieStrategy>) : MovieService {
    override fun findTopMovies(movieStrategy: MovieStrategy): List<Movie> =
        movieStrategies
            .first { it.supports(movieStrategy) }
            .also {
                logger.info { "Getting top movies by strategy $movieStrategy" }
            }
            .findTop()

    companion object : KLogging()
}
