package guillermo.lagos.moofwd.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import guillermo.lagos.moofwd.data.repository.NewsRepository
import guillermo.lagos.moofwd.data.source.LocalDataSource
import guillermo.lagos.moofwd.data.source.RemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun newsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ) = NewsRepository(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource
    )
}