package com.filipeoliveira.pocketmiibo.data

import com.filipeoliveira.pocketmiibo.data.remote.IGameSeriesDataSource
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GameSeriesRepositoryImpl @Inject constructor (
    private val remoteDataSource: IGameSeriesDataSource
) : IGameSeriesRepository {

    override suspend fun getGameSeries(): Flow<List<GameSeriesUI>> = remoteDataSource.getGameSeries().flowOn(Dispatchers.IO)
}