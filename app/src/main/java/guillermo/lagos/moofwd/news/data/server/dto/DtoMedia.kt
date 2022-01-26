package guillermo.lagos.moofwd.news.data.server.dto

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "media:content")
data class DtoMedia(

    @Attribute(name = "url")
    val url: String? = null

)
