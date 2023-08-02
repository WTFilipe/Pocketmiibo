package com.filipeoliveira.pocketmiibo.data.remote

import com.filipeoliveira.pocketmiibo.data.remote.models.AmiiboListResponse
import com.filipeoliveira.pocketmiibo.data.remote.models.CharacterDetailResponse
import com.filipeoliveira.pocketmiibo.data.remote.models.GameSeriesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("amiibo/")
    suspend fun getAmiiboListByName(@Query("name") string: String) : AmiiboListResponse

    @GET
    suspend fun getGameSeries() : GameSeriesListResponse

    @GET
    suspend fun getCharacterDetail(string: String) : CharacterDetailResponse
}