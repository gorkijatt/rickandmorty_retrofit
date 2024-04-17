package com.example.kotlin1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin1.ui.theme.Kotlin1Theme


/**
 * Jetpack Compose Basic Example
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            Kotlin1Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        // Text Compose
                        Row {
                            TextCompose(name = "Gorki !!")
                        }

                        //storing the value of the current image while it's default value is 1
                        var currentImage by remember { mutableStateOf(1) }

                        // Image Compose
                        Row {
                            ImageCompose(whichImage = currentImage)
                        }

                        // Button Compose
                        Row {
                            ButtonCompose(
                                //when onclick action is done than the ui updated will done where the changes are occur
                                //in our case ImageCompose will be called again but not other ui elements
                                onClick = {
                                    currentImage = if (currentImage == 1) 2 else 1
                                },
                            )
                        }

                        // Text Input
                        Row {
                            TextFieldCompose()
                        }

                    }



                }
            }
        }

    }
}



@Composable
fun ButtonCompose(onClick: () -> Unit,modifier: Modifier = Modifier){
    Log.d("Kotlin1Activity","Button Compose Called");
    Button(
        onClick = onClick,
        modifier = Modifier.width(150.dp)) {
            Text(
                modifier = modifier,
                text = "Click Me",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
}

@Composable
fun TextCompose(name: String, modifier: Modifier = Modifier) {
    Log.d("Kotlin1Activity","Text Compose Called");
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        text = "Hello $name!",
        fontSize = 36.sp,
        fontFamily = FontFamily.Monospace,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ImageCompose(whichImage:Int,modifier: Modifier = Modifier){
    Log.d("Kotlin1Activity","Image Compose Called");
    val imageRes = if (whichImage == 1) {
        R.drawable.db
    } else {
        R.drawable.wonder
    }

    Image(
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = imageRes),
        contentDescription = "Dragon Ball"
    )
}

@Composable
fun TextFieldCompose(modifier: Modifier = Modifier) {
    //this will remember the state of the value so when the compose is recreated the value does not lost
    val state = remember { mutableStateOf("") }

    Log.d("Kotlin1Activity","TextFieldCompose Called");

    //text field
    TextField(value = state.value, onValueChange = {
        state.value = it
    }, label = {
        Text(text = "Enter Your Message")
    })
}