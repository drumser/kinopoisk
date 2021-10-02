package ru.quantick.kinopoisk.movie.service

import mu.KLogging
import org.springframework.stereotype.Service
import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.provider.MovieProvider

@Service
class MovieServiceImpl(val movieProvider: MovieProvider) : MovieService {
    override fun getTopMoviesForTheMonth(): List<Movie> = movieProvider
        .getTopForTheMonth()
        .also {
            logger.info { "Got ${it.size} movies from provider ${movieProvider.javaClass}" }
        }

    companion object : KLogging()
}
