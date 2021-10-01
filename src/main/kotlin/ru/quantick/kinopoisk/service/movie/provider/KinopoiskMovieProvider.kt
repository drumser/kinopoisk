package ru.quantick.kinopoisk.service.movie.provider

import mu.KLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.client.bodyToMono
import ru.quantick.kinopoisk.configuration.movieprovider.KinopoiskProviderConfiguration
import ru.quantick.kinopoisk.model.Movie


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

@Service
class KinopoiskMovieProvider(
    val kinopoiskProviderConfiguration: KinopoiskProviderConfiguration
) : MovieProvider {
    @Cacheable("kinopoisk:get-top-for-a-month")
    override fun getTopForTheMonth(): List<Movie> {
        val client = prepareClient()

        return try {
            fetchList(client)
        } catch (e: WebClientResponseException) {
            emptyList<Movie>().also {
                logger.error { "Error during request to kinopoisk. Code: ${e.statusCode}; Error: ${e.message}" }
            }
        }
    }

    private fun fetchList(client: WebClient) =
        client.get().uri { builder ->
            builder.path("/selections")
                .queryParam("itemsLimit", 10)
                .queryParam("pageId", "subscriptions")
                .queryParam("selectionWindowId", "ya_plus")
                .queryParam("selectionsLimit", 10)
                .queryParam("selectionsOffset", 0)
                .queryParam("serviceId", 25)
                .build()
        }
            .header(
                HttpHeaders.USER_AGENT,
                prepareUserAgent()
            )
            .retrieve()
            .bodyToMono<TopMovieListResponse>()
            .block()
            ?.let { response ->
                response.collections
                    .first { it.type == "OTT_TOP" }
                    .data
                    .map {
                        Movie(
                            id = it.id,
                            title = it.title,
                            genres = it.genres,
                            posterUrl = it.posterUrl,
                            years = it.years
                        )
                    }
            } ?: emptyList()

    private fun prepareUserAgent() =
        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36"

    private fun prepareClient(): WebClient =
        WebClient.builder()
            .baseUrl(kinopoiskProviderConfiguration.baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

    companion object: KLogging()
}
