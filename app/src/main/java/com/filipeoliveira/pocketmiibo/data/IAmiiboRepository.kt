package com.filipeoliveira.pocketmiibo.data

import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow

interface IAmiiboRepository {

    suspend fun searchAmiiboByName(name: String) : Flow<List<AmiiboUI>>

    suspend fun getGameSeries() : Flow<List<GameSeriesUI>>

    suspend fun getCharacterDetail(id: String) : Flow<CharacterUI>
}