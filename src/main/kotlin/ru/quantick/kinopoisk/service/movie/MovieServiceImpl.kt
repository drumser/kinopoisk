package ru.quantick.kinopoisk.service.movie

import mu.KotlinLogging
import org.springframework.stereotype.Component
import ru.quantick.kinopoisk.model.Movie
import ru.quantick.kinopoisk.service.movie.provider.MovieProvider

private val logger = KotlinLogging.logger {}

@Component
class MovieServiceImpl(val movieProvider: MovieProvider) : MovieService {
    override fun getTopMoviesForAMonth(): List<Movie> {
        return movieProvider.getTopForAMonth().also {
            logger.info { "Got ${it.size} movies from provider ${movieProvider.javaClass}" }
        }
    }
}
