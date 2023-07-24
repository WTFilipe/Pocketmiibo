package com.filipeoliveira.pocketmiibo.data.remote

import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow

interface IGameSeriesDataSource {

    suspend fun getGameSeries() : Flow<List<GameSeriesUI>>
}