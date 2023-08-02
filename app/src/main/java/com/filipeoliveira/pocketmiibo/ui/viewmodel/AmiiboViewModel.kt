package com.filipeoliveira.pocketmiibo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.pocketmiibo.domain.SearchAmiiboByNameUseCase
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmiiboViewModel @Inject constructor(
    private val searchAmiiboByNameUseCase: SearchAmiiboByNameUseCase
) : ViewModel() {

    private val _amiiboListResponseUIState = MutableStateFlow(UIState.Success<List<AmiiboUI>>(emptyList()))
    val amiiboListResponseUIState: StateFlow<UIState<List<AmiiboUI>>> = _amiiboListResponseUIState


    fun searchAmiiboByName(name: String) {
        viewModelScope.launch {
            searchAmiiboByNameUseCase.execute(name)
                .onStart {  }
                .catch { }
                .collect { data ->
                    _amiiboListResponseUIState.emit(UIState.Success(data))
                }
        }
    }

//    fun getAmiiboDetail(id: String) {
//        viewModelScope.launch {
//            amiiboRepository.getCharacterDetail(id)
//                .catch { }
//                .collect {
//
//                }
//        }
//    }
}