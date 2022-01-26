package guillermo.lagos.moofwd.news.data.server.dto

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "rss")
data class DtoRss(

    @Element
    var channel: DtoChannel
)