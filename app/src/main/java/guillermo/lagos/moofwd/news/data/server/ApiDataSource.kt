package guillermo.lagos.moofwd.news.data.server

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit

object ApiDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rss.nytimes.com/services/xml/rss/nyt/")
        .addConverterFactory(TikXmlConverterFactory.create(
            TikXml.Builder()
                .exceptionOnUnreadXml(false)
                .build()
        ))
        .build()

    val service: ApiServices = retrofit.run{
        create(ApiServices::class.java)
    }
}