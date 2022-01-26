package guillermo.lagos.moofwd.data.source

import guillermo.lagos.moofwd.domain.New

interface LocalDataSource {

    suspend fun cleanNews()

    suspend fun saveNews(news: List<New>)

    suspend fun getNews(): List<New>

    suspend fun getNewById(id: Int): New?

}