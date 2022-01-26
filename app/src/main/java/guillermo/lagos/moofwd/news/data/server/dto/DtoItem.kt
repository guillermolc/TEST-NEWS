package guillermo.lagos.moofwd.news.data.server.dto

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter

@Xml(name = "item")
data class DtoItem(

    @PropertyElement(converter = HtmlEscapeStringConverter::class)
    val title: String? = null,

    @PropertyElement(converter = HtmlEscapeStringConverter::class)
    val description: String? = null,

    @PropertyElement
    val pubDate: String? = null,

    @Element(name = "media:content")
    var media: DtoMedia? = null
)
