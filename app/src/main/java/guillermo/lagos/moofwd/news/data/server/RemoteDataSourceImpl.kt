package guillermo.lagos.moofwd.news.data.server

import android.util.Log
import guillermo.lagos.moofwd.data.source.RemoteDataSource
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.news.data.server.dto.DtoItem
import guillermo.lagos.moofwd.news.data.toNews

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getNews(): List<New> {
        return ApiDataSource
            .service
            .getNews()
            .channel
            .items
            .toNews()

    }
}