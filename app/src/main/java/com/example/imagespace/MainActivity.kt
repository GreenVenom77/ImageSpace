package com.example.imagespace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imagespace.ui.theme.ImageSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceView("Android")
                }
            }
        }
    }
}

@Composable
fun getSpaceInfo(index: Int): String {

    val info: String = when(index) {
        1 -> stringResource(R.string.app_name)

        else -> "Done"
    }

    return info
}

@Composable
fun getSpaceImage(index: Int): Painter {

        val image: Painter = when(index) {
        1 -> painterResource(R.drawable._209063)

        else -> painterResource(R.drawable.ic_launcher_background)
    }

    return image
}

@Composable
fun SpaceView(name: String, modifier: Modifier = Modifier) {

    Surface(
        color = Color.DarkGray,
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                ) {

                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(2f)
            ) {
                Box(
                    modifier = Modifier
                        .aspectRatio(0.5f)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = getSpaceImage(1),
                        contentDescription = "Nothing",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxHeight()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = getSpaceInfo(1)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                ) {

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    ImageSpaceTheme {
        SpaceView("Android")
    }
}