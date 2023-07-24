package com.filipeoliveira.pocketmiibo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.pocketmiibo.data.IGameSeriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameSeriesViewModel @Inject constructor(
    private val gameSeriesRepository: IGameSeriesRepository
) : ViewModel() {

    fun getGameSeries(){
        viewModelScope.launch {
            gameSeriesRepository.getGameSeries()
                .catch {  }
                .collect {

                }
        }
    }
    
}