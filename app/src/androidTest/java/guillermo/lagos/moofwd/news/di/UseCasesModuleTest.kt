package guillermo.lagos.moofwd.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.testing.TestInstallIn
import guillermo.lagos.moofwd.data.repository.NewsRepository
import guillermo.lagos.moofwd.usecases.GetNewById
import guillermo.lagos.moofwd.usecases.GetNews

@Module
@TestInstallIn(
    components = [
        ViewModelComponent::class
    ],
    replaces = [
        UseCasesModule::class
    ]
)
abstract class UseCasesModuleTest {

    @Provides
    @ViewModelScoped
    fun getNewsProvider(
        newsRepository: NewsRepository
    ) = GetNews(
        newsRepository = newsRepository
    )

    @Provides
    @ViewModelScoped
    fun getNewByIdProvider(
        newsRepository: NewsRepository
    ) = GetNewById(
        newsRepository = newsRepository
    )
}