package com.filipeoliveira.pocketmiibo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.pocketmiibo.domain.SearchAmiiboByNameUseCase
import com.filipeoliveira.pocketmiibo.ui.models.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmiiboViewModel @Inject constructor(
    private val searchAmiiboByNameUseCase: SearchAmiiboByNameUseCase
) : ViewModel() {

    private val _amiiboListResponseUIState = MutableStateFlow(HomeUIState())
    val amiiboListResponseUIState: StateFlow<HomeUIState> = _amiiboListResponseUIState

    init {
        searchAmiiboByName("")
    }


    fun searchAmiiboByName(name: String) {
        viewModelScope.launch {
            searchAmiiboByNameUseCase.execute(name)
                .onStart {
                    _amiiboListResponseUIState.update { it.copy(isLoading = true, error = null) }
                }
                .catch {error ->
                    _amiiboListResponseUIState.update { it.copy(isLoading = false, error = error) }
                }
                .collect { data ->
                    _amiiboListResponseUIState.emit(
                        HomeUIState(amiiboList = data)
                    )
                }
        }
    }
}