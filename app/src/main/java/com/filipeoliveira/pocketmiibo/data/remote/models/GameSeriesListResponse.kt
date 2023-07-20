package com.filipeoliveira.pocketmiibo.data.remote.models

import com.google.gson.annotations.SerializedName

data class GameSeriesListResponse(
    @SerializedName("amiibo")
    val gameSeries: List<GameSeries>?
)