package com.filipeoliveira.pocketmiibo.data

import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow

interface IGameSeriesRepository {

    suspend fun getGameSeries() : Flow<List<GameSeriesUI>>

}