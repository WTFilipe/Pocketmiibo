package com.filipeoliveira.pocketmiibo.data.remote.models

import com.filipeoliveira.pocketmiibo.ui.models.CharacterUI

data class Character(
    val amiiboSeries: String?,
    val character: String?,
    val gameSeries: String?,
    val head: String?,
    val image: String?,
    val name: String?,
    val tail: String?,
    val type: String?
) {
    fun toUIModel() : CharacterUI{
        return CharacterUI(
            amiiboSeries = amiiboSeries ?: "",
            character = character ?: "",
            gameSeries = gameSeries ?: "",
            head = head ?: "",
            image = image ?: "",
            name = name ?: "",
            tail = tail ?: "",
            type = type ?: ""
        )
    }
}