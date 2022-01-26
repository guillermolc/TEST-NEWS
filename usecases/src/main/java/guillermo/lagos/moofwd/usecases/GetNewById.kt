package guillermo.lagos.moofwd.usecases

import guillermo.lagos.moofwd.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNewById(
    private val newsRepository: NewsRepository
) {

    fun invoke(id: Int) = flow{

        emit(newsRepository.getNewById(id))

    }.flowOn(Dispatchers.IO)
}