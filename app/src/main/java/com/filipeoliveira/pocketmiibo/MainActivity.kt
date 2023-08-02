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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filipeoliveira.pocketmiibo.ui.AmiiboItem
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.models.UIState
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
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home(viewModel)
                }
            }
        }
    }
}

@Composable
private fun Home(viewModel: AmiiboViewModel) {
    val screenState = viewModel.amiiboListResponseUIState.collectAsState()
    viewModel.searchAmiiboByName("mario")
    when (screenState.value) {
        is UIState.Loading -> ShowLoading()
        is UIState.Error -> ShowError()
        is UIState.Success -> ShowList(list = screenState.value as UIState.Success)
    }
}

@Composable
fun ShowList(
    modifier: Modifier = Modifier,
    list: UIState.Success<List<AmiiboUI>>
) {
    val amiiboList = list.data

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(amiiboList) { amiibo ->
            AmiiboItem(item = amiibo) {

            }
        }
    }
}

@Composable
fun ShowError(){

}

@Composable
fun ShowLoading(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PocketmiiboTheme {
    }
}