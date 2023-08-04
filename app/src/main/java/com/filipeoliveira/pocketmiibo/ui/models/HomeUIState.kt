package com.filipeoliveira.pocketmiibo.ui.models

data class HomeUIState(
    val amiiboList: List<AmiiboUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null
) {

    val isError: Boolean
        get() = error != null

    val isSuccess: Boolean
        get() = amiiboList.isNotEmpty()
}
