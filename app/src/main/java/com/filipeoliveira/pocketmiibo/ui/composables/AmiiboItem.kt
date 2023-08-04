package com.filipeoliveira.pocketmiibo.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.filipeoliveira.pocketmiibo.R
import com.filipeoliveira.pocketmiibo.ui.models.AmiiboUI
import com.filipeoliveira.pocketmiibo.ui.theme.PocketmiiboTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmiiboItem(modifier: Modifier = Modifier, item: AmiiboUI, onItemClick: () -> Unit) {

    Card(
        onClick = onItemClick,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.dimen_8dp))
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = item.image,
                contentDescription = null,
            )
        }

        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.dimen_8dp)),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun AmiiboItemPreview() {
    PocketmiiboTheme {
        val amiibo = AmiiboUI(
            type = "",
            tail = "",
            name = "Filipe",
            image = "https://cdn.awsli.com.br/2500x2500/138/138431/produto/11179849/11ffd2a092.jpg",
            head = "",
            amiiboSeries = "",
            character = "",
            gameSeries = ""
        )
        AmiiboItem(item = amiibo) {

        }
    }
}