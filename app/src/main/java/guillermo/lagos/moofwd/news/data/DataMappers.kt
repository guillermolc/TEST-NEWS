package guillermo.lagos.moofwd.news.data

import android.util.Log
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.news.data.local.model.EttNew
import guillermo.lagos.moofwd.news.data.server.dto.DtoItem
import java.text.SimpleDateFormat
import java.util.*

fun DtoItem.toNew() = New(
    id = 0,
    title = title,
    description = description,
    pictureUrl = media?.url,
    date = pubDate?.toFormattedDate()
)

fun List<DtoItem>.toNews() = map { it.toNew() }


fun New.toLocalNew() = EttNew(
    title = title,
    description = description,
    pictureUrl = pictureUrl,
    date = date
)

fun List<New>.toLocalNews() = map { it.toLocalNew() }


fun String.toFormattedDate(): String? = try {

    val initial = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
    val final = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    val initialDate = initial.parse(this)
    if (initialDate != null) final.format(initialDate)

    else null

}catch (e: Exception){
    /*Log.e("GLAGOS", "DATE ERROR: $e")*/
    null
}

fun EttNew.toDomainNew() = New(
    id = id,
    title = title,
    description = description,
    pictureUrl = pictureUrl,
    date = date
)

fun List<EttNew>.toDomainNews() = map { it.toDomainNew() }