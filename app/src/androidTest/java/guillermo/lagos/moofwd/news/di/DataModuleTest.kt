package guillermo.lagos.moofwd.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import guillermo.lagos.moofwd.data.repository.NewsRepository
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource

@Module
@TestInstallIn(
    components = [
        SingletonComponent::class
    ],
    replaces = [
        DataModule::class
    ]
)
abstract class DataModuleTest {

    @Provides
    fun newsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ) = NewsRepository(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource
    )

}