package guillermo.lagos.moofwd.usecases

import guillermo.lagos.moofwd.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class GetNews(
    private val newsRepository: NewsRepository
) {

    fun invoke(
        onStart:() -> Unit,
        onError:(String) -> Unit
    ) = flow{

        delay(1000)

        emit(newsRepository.getNews())

    }.onStart {
        onStart()
    }.catch {
        onError(it.toString())
    }.flowOn(Dispatchers.IO)
}