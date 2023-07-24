package com.filipeoliveira.pocketmiibo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmiiboViewModel @Inject constructor(
    private val amiiboRepository: IAmiiboRepository
) : ViewModel() {

    fun searchAmiiboByName(name: String){
        viewModelScope.launch {
            amiiboRepository.searchAmiiboByName(name)
                .catch {  }
                .collect {

                }
        }
    }

    fun getAmiiboDetail(id: String){
        viewModelScope.launch {
            amiiboRepository.getCharacterDetail(id)
                .catch {  }
                .collect {

                }
        }
    }
}