package com.lalosapps.artspace

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lalosapps.artspace.data.Artwork
import com.lalosapps.artspace.data.ArtworkProvider.Companion.images
import com.lalosapps.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceApp()
        }
    }
}

@Composable
fun MyArtSpaceApp() {
    val image = images[1]
    ArtSpaceTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                ArtworkWall(image)
                ArtworkDescriptor(image)
                DisplayController(
                    onPreviousClick = {},
                    onNextClick = {}
                )
            }
        }
    }
}

@Composable
fun ArtworkWall(image: Artwork = images[1]) {
    val resource = when (image.id) {
        0 -> R.drawable.image1
        1 -> R.drawable.image2
        2 -> R.drawable.image3
        3 -> R.drawable.image4
        4 -> R.drawable.image5
        5 -> R.drawable.image6
        6 -> R.drawable.image7
        7 -> R.drawable.image8
        8 -> R.drawable.image9
        else -> R.drawable.image10
    }
    val isDark = isSystemInDarkTheme()
    Surface(
        modifier = Modifier
            .shadow(8.dp, spotColor = if (isDark) Color.White else Color.Black)
            .border(2.dp, Color.Gray)
    ) {
        Image(
            painter = painterResource(id = resource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtworkDescriptor(image: Artwork = images[1]) {
    val isDark = isSystemInDarkTheme()
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.shadow(8.dp, spotColor = if (isDark) Color.White else Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Text(
                text = image.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
            )
            Row {
                Text(
                    text = image.artist,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(${image.year})",
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Light
                    )
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(140.dp)
        ) {
            Text(text = stringResource(R.string.previous_button))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.width(140.dp)
        ) {
            Text(text = stringResource(R.string.next_button))
        }
    }

}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyArtSpaceAppPreview() {
    MyArtSpaceApp()
}