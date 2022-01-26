package guillermo.lagos.moofwd.news.ui.features.news

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.usecases.GetNews
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsVm
@Inject
constructor(
    private val getNews: GetNews
):ViewModel(){

    val loading = mutableStateOf(false)
    val error = mutableStateOf(false)
    val news = mutableStateListOf<New>()

    fun getNews() = getNews
        .invoke(
            onStart = {
              loading.value = true
            },
            onError = {
                loading.value = false
                error.value = true
                Log.e("GLAGOS","ERROR: $it")
            }
        )
        .onEach{
            loading.value = false
            /*Log.e("GLAGOS", "ITEMS: $it")*/
            news.clear()
            news.addAll(it)
        }.launchIn(viewModelScope)
}