package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchAmiiboByNameUseCase @Inject constructor (private val amiiboRepository: IAmiiboRepository) : ISearchAmiiboByNameUseCase {

    override suspend fun execute(name: String): Flow<List<AmiiboUI>> = amiiboRepository.searchAmiiboByName(name)
}