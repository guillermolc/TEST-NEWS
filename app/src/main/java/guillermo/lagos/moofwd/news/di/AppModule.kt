package guillermo.lagos.moofwd.news.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource
import guillermo.lagos.moofwd.news.data.local.Database
import guillermo.lagos.moofwd.news.data.local.LocalDataSourceImpl
import guillermo.lagos.moofwd.news.data.server.RemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = RemoteDataSourceImpl()

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        Database::class.java,
        "news.db"
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    fun localDataSourceProvider(
        db: Database
    ): LocalDataSource = LocalDataSourceImpl(db)

}