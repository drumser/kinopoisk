package ru.quantick.kinopoisk.movie.service.provider

data class TopMovieListResponse(
    val collections: List<CollectionItem>,
    val status: String
)

data class CollectionItem(
    val data: List<DataItem>,
    val type: String
)

data class DataItem(
    val id: String,
    val title: String,
    val genres: List<String>?,
    val posterUrl: String?,
    val years: String?
)
