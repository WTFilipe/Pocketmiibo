package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGameSeriesUseCase @Inject constructor (private val amiiboRepository: IAmiiboRepository) : IGetGameSeriesUseCase {

    override suspend fun execute(): Flow<List<GameSeriesUI>> = amiiboRepository.getGameSeries()
}