package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor (private val amiiboRepository: IAmiiboRepository) : IGetCharacterDetailUseCase {

    override suspend fun execute(id: String): Flow<CharacterUI> = amiiboRepository.getCharacterDetail(id)
}