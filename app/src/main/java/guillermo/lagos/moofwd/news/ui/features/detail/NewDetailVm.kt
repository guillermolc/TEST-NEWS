package guillermo.lagos.moofwd.news.ui.features.detail

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.usecases.GetNewById
import guillermo.lagos.moofwd.usecases.GetNews
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewDetailVm
@Inject
constructor(
    private val getNewById: GetNewById
):ViewModel(){

    val new = mutableStateOf<New?>(null)

    fun getNewById(
        id: Int
    ) = getNewById
        .invoke(id = id)
        .onEach{
            /*Log.e("GLAGOS", "NEW: $it")*/
            new.value = it
        }.launchIn(viewModelScope)
}