package guillermo.lagos.moofwd.usecases

import guillermo.lagos.moofwd.data.repository.NewsRepository
import guillermo.lagos.moofwd.testshared.mockedNews
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetNewsTest {

    @Mock
    lateinit var newsRepository: NewsRepository

    @Mock
    lateinit var getNews: GetNews

    @Before
    fun setUp() {
        getNews = GetNews(newsRepository = newsRepository)
    }

    @Test
    fun `invoke for get all news from db`() {
        runBlocking {

            val news = mockedNews.toMutableList()

            val result = getNews.invoke(
                onStart = {},
                onError = {}
            ).firstOrNull() ?: news

            assertEquals(result, news)

        }
    }
}