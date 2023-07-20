package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow

class GetGameSeriesUseCase (private val amiiboRepository: IAmiiboRepository) : IGetGameSeriesUseCase {

    override suspend fun execute(): Flow<List<GameSeriesUI>> = amiiboRepository.getGameSeries()
}