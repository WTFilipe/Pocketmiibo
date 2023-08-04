package com.filipeoliveira.pocketmiibo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.filipeoliveira.pocketmiibo.ui.composables.AmiiboItem
import com.filipeoliveira.pocketmiibo.ui.composables.DefaultError
import com.filipeoliveira.pocketmiibo.ui.composables.DefaultLoading
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.theme.PocketmiiboTheme
import com.filipeoliveira.pocketmiibo.ui.viewmodel.AmiiboViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AmiiboViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketmiiboTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home(viewModel)
                }
            }
        }
    }
}

@Composable
private fun Home(viewModel: AmiiboViewModel) {
    val screenState = viewModel.amiiboListResponseUIState.collectAsState().value
    when {
        screenState.isLoading -> ShowLoading()
        screenState.isError -> ShowError(screenState.error){
//            viewModel.searchAmiiboByName("mario")
        }
        screenState.isSuccess -> ShowList(amiiboList = screenState.amiiboList)
    }
}

@Composable
fun ShowList(
    modifier: Modifier = Modifier,
    amiiboList: List<AmiiboUI>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.dimen_16dp)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8dp)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8dp))
    ) {
        items(amiiboList) { amiibo ->
            AmiiboItem(
                item = amiibo

            ) {

            }
        }
    }
}

@Composable
fun ShowError(error: Throwable?, onErrorClicked: () -> Unit) {
    DefaultError(throwable = error) {
        onErrorClicked()
    }
}

@Composable
fun ShowLoading(){
    DefaultLoading()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PocketmiiboTheme {
    }
}