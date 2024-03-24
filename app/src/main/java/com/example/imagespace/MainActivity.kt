package com.example.imagespace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    SpaceView()
                }
            }
        }
    }
}

@Composable
fun getSpaceInfo(index: Int): String {

    val info: String = when(index) {
        1 -> stringResource(R.string.image_one)
        2 -> stringResource(R.string.image_two)
        3 -> stringResource(R.string.image_three)
        4 -> stringResource(R.string.image_four)

        else -> "Done"
    }

    return info
}

@Composable
fun getSpaceImage(index: Int): Painter {

    var image: Painter = painterResource(R.drawable._209063)

    when(index) {
        1 -> image = painterResource(R.drawable._209063)
        2 -> image = painterResource(R.drawable._209101)
        3 -> image = painterResource(R.drawable._443174)
        4 -> image = painterResource(R.drawable._918066)
    }

    return image
}

@Composable
fun getSpaceDescription(index: Int): String {

    val description: String = when(index) {
        1 -> stringResource(R.string.desc_one)
        2 -> stringResource(R.string.desc_two)
        3 -> stringResource(R.string.desc_three)
        4 -> stringResource(R.string.desc_four)

        else -> "Done"
    }

    return description
}

@Composable
fun SpaceView(modifier: Modifier = Modifier) {

    var imageIndex by remember { mutableIntStateOf(1) }
    var infoIndex by remember { mutableIntStateOf(1) }
    var descriptionIndex by remember { mutableIntStateOf(1) }
    val maxInteractions by remember { mutableIntStateOf(4) }
    var currentIndex by remember { mutableIntStateOf(1) }

    val image: Painter = getSpaceImage(imageIndex)
    val info: String = getSpaceInfo(infoIndex)
    val cDescription: String = getSpaceDescription(descriptionIndex)

    Surface(
        color = Color.White,
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
                    .padding(8.dp)
            ) {
                Button(
                    onClick = {
                        if (currentIndex in 2..maxInteractions) {
                            imageIndex -= 1
                            descriptionIndex -= 1
                            infoIndex -= 1
                            currentIndex -= 1
                        }
                    },
                ) {
                    Text("<")
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
                        .border(width = 7.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Image(
                        painter = image,
                        contentDescription = cDescription,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxHeight()
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = info,
                    fontSize = 20.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .padding(8.dp)
            ) {
                Button(
                    onClick = {
                          if (currentIndex < maxInteractions) {
                              imageIndex += 1
                              descriptionIndex += 1
                              infoIndex += 1
                              currentIndex += 1
                          }
                    },
                ) {
                    Text(">")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    ImageSpaceTheme {
        SpaceView()
    }
}