package com.filipeoliveira.pocketmiibo.data.remote.models

data class AmiiboX(
    val amiiboSeries: String?,
    val character: String?,
    val gameSeries: String?,
    val games3DS: List<Games3DS>?,
    val gamesSwitch: List<GamesSwitch>?,
    val gamesWiiU: List<GamesWiiU>?,
    val head: String?,
    val image: String?,
    val name: String?,
    val release: ReleaseX?,
    val tail: String?,
    val type: String?
)