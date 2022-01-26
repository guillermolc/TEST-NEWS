package guillermo.lagos.moofwd.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import guillermo.lagos.moofwd.news.data.local.dao.DaoNew
import guillermo.lagos.moofwd.news.data.local.model.EttNew

@Database(
    entities = [EttNew::class],
    version = 1,
    exportSchema = false
)
abstract class Database: RoomDatabase() {

    abstract fun daoNew(): DaoNew

}