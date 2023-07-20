package com.filipeoliveira.pocketmiibo.data.remote

import com.filipeoliveira.pocketmiibo.data.remote.models.AmiiboListResponse
import com.filipeoliveira.pocketmiibo.data.remote.models.CharacterDetailResponse
import com.filipeoliveira.pocketmiibo.data.remote.models.GameSeriesListResponse
import retrofit2.http.GET

interface APIService {

    @GET
    fun getAmiiboListByName(string: String) : AmiiboListResponse

    @GET
    fun getGameSeries() : GameSeriesListResponse

    @GET
    fun getCharacterDetail(string: String) : CharacterDetailResponse
}