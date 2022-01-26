package guillermo.lagos.moofwd.news.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import guillermo.lagos.moofwd.news.data.local.model.EttNew

@Dao
interface DaoNew {

    @Query("DELETE FROM EttNew")
    fun clean()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveNews(items: List<EttNew>)

    @Query("""
        SELECT * FROM EttNew
    """)
    fun getNews(): List<EttNew>

    @Query("""
        SELECT * FROM EttNew
        WHERE id = :id
        LIMIT 1
    """)
    fun getNewById(id: Int): EttNew?
}