package guillermo.lagos.moofwd.data.source

import guillermo.lagos.moofwd.domain.New

interface RemoteDataSource {

    suspend fun getNews(): List<New>

}