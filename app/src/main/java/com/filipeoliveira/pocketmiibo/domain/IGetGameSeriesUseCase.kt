package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow

interface IGetGameSeriesUseCase {

    suspend fun execute() : Flow<List<GameSeriesUI>>
}