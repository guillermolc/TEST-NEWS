package guillermo.lagos.moofwd.data.repository

import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource
import guillermo.lagos.moofwd.domain.New

class NewsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getNews(): List<New> {

        val news = remoteDataSource.getNews()

        localDataSource.cleanNews()
        localDataSource.saveNews(news)

        return localDataSource.getNews()
    }

    suspend fun getNewById(id: Int): New?{
        return localDataSource.getNewById(id)
    }

}