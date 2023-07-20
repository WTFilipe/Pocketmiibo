package com.filipeoliveira.pocketmiibo.data.remote.models

import com.filipeoliveira.pocketmiibo.ui.models.GameSeriesUI

data class GameSeries(
    val key: String?,
    val name: String?
) {

    fun toUIModel(): GameSeriesUI {
        return GameSeriesUI(
            key = key ?: "",
            name = name ?: ""
        )
    }
}