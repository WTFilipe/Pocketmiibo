package com.filipeoliveira.pocketmiibo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.filipeoliveira.pocketmiibo.R
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

@Composable
fun DefaultError(modifier: Modifier = Modifier, mainErrorFeedback: String = stringResource(id = R.string.error_generic_feedback), throwable: Throwable?, onErrorClicked: () -> Unit){

    val errorFeedback = when (throwable){
        is UnknownHostException -> stringResource(id = R.string.error_no_connection_feedback)
        is TimeoutException -> stringResource(id = R.string.error_slow_connection_feedback)
        else -> mainErrorFeedback
    }

    Surface(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {

        TextButton(onClick = onErrorClicked) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.dimen_8dp)),
                text = errorFeedback,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun DefaultErrorPreview(){
    DefaultError(
        mainErrorFeedback = stringResource(id = R.string.error_generic_feedback),
        throwable = Throwable()) {

    }
}