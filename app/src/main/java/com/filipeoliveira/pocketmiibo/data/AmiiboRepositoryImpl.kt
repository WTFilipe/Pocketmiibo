package com.filipeoliveira.pocketmiibo.data

import com.filipeoliveira.pocketmiibo.data.remote.IAmiiboRemoteDataSource
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI
import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AmiiboRepositoryImpl @Inject constructor (
    private val remoteDataSource: IAmiiboRemoteDataSource
) : IAmiiboRepository {

    override suspend fun searchAmiiboByName(name: String): Flow<List<AmiiboUI>> = remoteDataSource.searchAmiiboByName(name).flowOn(Dispatchers.IO)

    override suspend fun getGameSeries(): Flow<List<GameSeriesUI>> = remoteDataSource.getGameSeries().flowOn(Dispatchers.IO)

    override suspend fun getCharacterDetail(id: String): Flow<CharacterUI> = remoteDataSource.getCharacterDetail(id).flowOn(Dispatchers.IO)
}