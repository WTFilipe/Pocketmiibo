package com.filipeoliveira.pocketmiibo.data.remote

import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameSeriesRemoteDataSourceImpl @Inject constructor(private val apiService: APIService): IGameSeriesDataSource {

    override suspend fun getGameSeries(): Flow<List<GameSeriesUI>> = flow {
        val listInUIModel = apiService.getGameSeries().gameSeries?.map {
            it.toUIModel()
        } ?: emptyList()

        emit(listInUIModel)
    }

}