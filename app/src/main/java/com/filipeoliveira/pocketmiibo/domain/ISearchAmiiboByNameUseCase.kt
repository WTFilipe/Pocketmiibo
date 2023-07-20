package com.filipeoliveira.pocketmiibo.domain

import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import kotlinx.coroutines.flow.Flow

interface ISearchAmiiboByNameUseCase {

    suspend fun execute(name: String) : Flow<List<AmiiboUI>>
}