package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.data.IGameSeriesRepository
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGameSeriesUseCase @Inject constructor (private val amiiboRepository: IGameSeriesRepository) : IGetGameSeriesUseCase {

    override suspend fun execute(): Flow<List<GameSeriesUI>> = amiiboRepository.getGameSeries()
}