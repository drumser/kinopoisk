package ru.quantick.kinopoisk.movie.service.strategy

import org.springframework.stereotype.Service
import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.model.MovieStrategy
import ru.quantick.kinopoisk.movie.provider.MovieProvider

@Service
class TopMonthMovieStrategy(
    val movieProvider: MovieProvider
) : TopMovieStrategy {
    override fun findTop(): List<Movie> = movieProvider.findTopForTheMonth()
    override fun supports(movieStrategy: MovieStrategy): Boolean = movieStrategy == MovieStrategy.TOP_MONTH
}
