package guillermo.lagos.moofwd.news.data.server.dto

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter

@Xml(name = "channel")
data class DtoChannel(

    @Element
    val items: List<DtoItem>
)
