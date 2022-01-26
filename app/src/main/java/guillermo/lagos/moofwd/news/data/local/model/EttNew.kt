package guillermo.lagos.moofwd.news.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EttNew(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String?,

    val description: String?,

    val pictureUrl: String?,

    val date: String?

)
