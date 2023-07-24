package com.filipeoliveira.pocketmiibo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.filipeoliveira.pocketmiibo.ui.theme.PocketmiiboTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmiiboItem(modifier: Modifier = Modifier, name: String, imageURL: String) {

    Card(onClick = { /*TODO*/ }, modifier = modifier) {
        Column {
            AsyncImage(
                model = imageURL,
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name)
    }
}

@Preview
@Composable
fun AmiiboItemPreview(){
    PocketmiiboTheme {
        AmiiboItem(name = "Filipe", imageURL = "https://cdn.awsli.com.br/2500x2500/138/138431/produto/11179849/11ffd2a092.jpg")
    }
}