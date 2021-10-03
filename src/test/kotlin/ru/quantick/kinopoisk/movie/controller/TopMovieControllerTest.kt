package ru.quantick.kinopoisk.movie.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.quantick.kinopoisk.movie.model.Movie
import ru.quantick.kinopoisk.movie.model.MovieStrategy
import ru.quantick.kinopoisk.movie.provider.MovieProvider

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class TopMovieControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var movieProvider: MovieProvider

    @Test
    fun getTopMovie() {
        every { movieProvider.findTopForTheMonth() } returns getFakeMovies()

        mockMvc.get("/movies/top?type=${MovieStrategy.TOP_MONTH}").andExpect {
            status { isOk() }
            content {
                contentType(MediaType.APPLICATION_JSON)
                MockMvcResultMatchers.jsonPath("$.movies.length()", 3)
            }
        }
    }

    @Test
    fun getTopSeries() {
        every { movieProvider.findTopSeries() } returns getFakeMovies()

        mockMvc.get("/movies/top?type=${MovieStrategy.TOP_SERIES}").andExpect {
            status { isOk() }
            content {
                contentType(MediaType.APPLICATION_JSON)
                MockMvcResultMatchers.jsonPath("$.movies.length()", 3)
            }
        }
    }

    @Test
    fun getWrongStrategy() {
        mockMvc.get("/movies/top?type=wrong_strategy").andExpect {
            status { is4xxClientError() }
        }
    }

    fun getFakeMovies() = listOf(
        Movie(
            id = "1",
            title = "Title1",
            genres = null,
            posterUrl = null,
            years = null
        ),
        Movie(
            id = "1",
            title = "Title2",
            genres = null,
            posterUrl = null,
            years = null
        ),
        Movie(
            id = "1",
            title = "Title3",
            genres = null,
            posterUrl = null,
            years = null
        ),
    )
}
