package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import kotlinx.coroutines.flow.Flow

interface IGetCharacterDetailUseCase {

    suspend fun execute(id: String) : Flow<CharacterUI>
}