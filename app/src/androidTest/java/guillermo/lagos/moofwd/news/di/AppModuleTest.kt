package guillermo.lagos.moofwd.news.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource
import guillermo.lagos.moofwd.news.data.local.Database
import guillermo.lagos.moofwd.news.data.local.LocalDataSourceImpl
import guillermo.lagos.moofwd.news.data.server.RemoteDataSourceImpl
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [
        SingletonComponent::class
    ],
    replaces = [
        AppModule::class
    ]
)
abstract class AppModuleTest {

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = RemoteDataSourceImpl()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.inMemoryDatabaseBuilder(
        context,
        Database::class.java
    ).build()

    @Provides
    fun localDataSourceProvider(
        db: Database
    ): LocalDataSource = LocalDataSourceImpl(db)

}