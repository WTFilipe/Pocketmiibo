package com.filipeoliveira.pocketmiibo.data

import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import kotlinx.coroutines.flow.Flow

interface IAmiiboRepository {

    suspend fun searchAmiiboByName(name: String) : Flow<List<AmiiboUI>>

    suspend fun getCharacterDetail(id: String) : Flow<CharacterUI>
}