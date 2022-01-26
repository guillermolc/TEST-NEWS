package guillermo.lagos.moofwd.usecases

import com.nhaarman.mockitokotlin2.verify
import guillermo.lagos.moofwd.data.repository.NewsRepository
import guillermo.lagos.moofwd.testshared.mockedNews
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetNewByIdTest {

    @Mock
    lateinit var newsRepository: NewsRepository

    @Mock
    lateinit var getNewById: GetNewById

    @Before
    fun setUp() {
        getNewById = GetNewById(newsRepository = newsRepository)
    }

    @Test
    fun `invoke for get new by id from db`() {
        runBlocking {

            val new = mockedNews.firstOrNull()

            val result = getNewById.invoke(1)
                .firstOrNull()
                ?: new

            assertEquals(result, new)

        }
    }
}