package ru.quantick.kinopoisk.movie.configuration.movieprovider

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConfigurationProperties(prefix = "movie-provider.kinopoisk")
data class KinopoiskProviderConfiguration @ConstructorBinding constructor(
    val baseUrl: String
)
