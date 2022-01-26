package guillermo.lagos.moofwd.data.repository

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource
import guillermo.lagos.moofwd.testshared.mockedNews
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.assertEquals

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {

    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var newsRepository: NewsRepository

    @Before
    fun setUp() {
        newsRepository = NewsRepository(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

    @Test
    fun getNews() = runBlocking{

        val dummyNews = mockedNews.toMutableList()

        whenever(remoteDataSource.getNews())
            .thenReturn(dummyNews)

        newsRepository.getNews()

        verify(localDataSource)
            .saveNews(dummyNews)

    }

    @Test
    fun getNewById(){
        runBlocking{

            val dummyNew = mockedNews
                .firstOrNull()

            whenever(localDataSource.getNewById(1))
                .thenReturn(dummyNew)

            val result = newsRepository.getNewById(1)

            assertEquals(dummyNew, result)

        }
    }
}