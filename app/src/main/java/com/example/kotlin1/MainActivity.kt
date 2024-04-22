package com.example.kotlin1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin1.ui.theme.Kotlin1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


/**
 * Jetpack Compose Layouts Example
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

                    ModifierM()

                }
            }
        }

    }

    @Composable
    @Preview(showBackground = true, widthDp = 300, heightDp = 500)
    private fun ModifierM() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello", color = Color.Black, modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary)
                .size(200.dp)
                .padding(10.dp)
                .border(4.dp,MaterialTheme.colorScheme.error)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onPrimaryContainer)
                .fillMaxSize()
                )
        }

    }

    @Composable
    private fun Users(){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ){
            UsersList(R.drawable.profile1,"Gorki","Software Developer")
            UsersList(R.drawable.profile2,"Jaskamal","Android Developer")
            UsersList(R.drawable.profile2,"Oscar","Kotlin Developer")
            UsersList(R.drawable.profile1,"Jaxy","PHP Developer")
        }
    }

    @Composable
    private fun UsersList(profile:Int,name:String,occupation:String){

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .fillMaxWidth()
            ){
                Image(painter = painterResource(profile), contentDescription = "Profile Photo")

                Column(
                    modifier = Modifier.padding(5.dp,5.dp,0.dp,0.dp)
                ) {
                    Text(text = "Name : $name")
                    Text(text = "Occupation : $occupation")
                }
            }

    }

    @Composable
    private fun BoxDisplay() {
       Box(
           contentAlignment = Alignment.Center
       ) {
           Image(painter = painterResource(id = R.drawable.cupid_), contentDescription = "Arrow",)
           Image(painter = painterResource(id = R.drawable.heart_), contentDescription = "Heart")
       }
    }

    @Composable
    private fun ColDisplay() {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "A", fontSize = 24.sp)
            Text(text = "B" , fontSize = 24.sp)
            Text(text = "C" , fontSize = 24.sp)
        }
    }

    @Composable
    private fun RowDisplay(){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "A", fontSize = 24.sp)
            Text(text = "B" , fontSize = 24.sp)
            Text(text = "C" , fontSize = 24.sp)
        }
    }
}