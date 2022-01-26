package guillermo.lagos.moofwd.news.data.local

import android.util.Log
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.news.data.toDomainNew
import guillermo.lagos.moofwd.news.data.toDomainNews
import guillermo.lagos.moofwd.news.data.toLocalNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSourceImpl(
    db: Database
): LocalDataSource {

    private val daoNew = db.daoNew()

    override suspend fun cleanNews() = withContext(Dispatchers.IO){
        daoNew.clean()
    }

    override suspend fun saveNews(
        news: List<New>
    ) = withContext(Dispatchers.IO){
        daoNew.saveNews(news.toLocalNews())
    }

    override suspend fun getNews(): List<New> = withContext(Dispatchers.IO){
        return@withContext daoNew
            .getNews()
            .toDomainNews()

    }

    override suspend fun getNewById(id: Int): New? = withContext(Dispatchers.IO){
        return@withContext daoNew
            .getNewById(id)
            ?.toDomainNew()
    }
}