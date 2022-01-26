package guillermo.lagos.moofwd.news.data.server

import guillermo.lagos.moofwd.news.data.server.dto.DtoRss
import retrofit2.http.GET

interface ApiServices {

    @GET("HomePage.xml")
    suspend fun getNews(): DtoRss

}