package com.filipeoliveira.pocketmiibo.data.remote

import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AmiiboRemoteDataSourceImpl @Inject constructor(private val apiService: APIService): IAmiiboRemoteDataSource {

    override suspend fun searchAmiiboByName(name: String): Flow<List<AmiiboUI>> = flow {
        val listInUIModel = apiService.getAmiiboListByName(string = name).amiibo?.filterNotNull()?.map {
            it.toUIModel()
        } ?: emptyList()

        emit(listInUIModel)
    }

    override suspend fun getGameSeries(): Flow<List<GameSeriesUI>> = flow {
        val listInUIModel = apiService.getGameSeries().gameSeries?.map {
            it.toUIModel()
        } ?: emptyList()

        emit(listInUIModel)
    }

    override suspend fun getCharacterDetail(id: String): Flow<CharacterUI> = flow {
        val characterInUIModel = apiService.getCharacterDetail(id)
        emit(characterInUIModel.amiibo.toUIModel())
    }
}