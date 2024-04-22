package com.example.kotlin1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
@Preview(showBackground = true, widthDp = 300, heightDp = 500)
fun PreviewItem(){
    LazyColumn(content={
        items(getCategoryData()){
            item ->
            BlogCategory(img = item.img, title = item.title, occupation = item.subtitle)
        }
    })
}

@Composable
fun BlogCategory(img:Int,title:String,occupation:String){
    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp
    ), modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(painter = painterResource(img),
                contentDescription = "Profile" ,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
                    .fillMaxHeight()
                    .weight(.2f)) //20% to images weight
            Details(title, occupation,Modifier.weight(.8f))
        }
    }
}

@Composable
private fun Details(title: String, occupation: String,modifier: Modifier) {
    Column(
        modifier = modifier //80% to the Column
    ) {
        Text(text = "$title", style = MaterialTheme.typography.bodyLarge)
        Text(text = "$occupation", style = MaterialTheme.typography.bodySmall)
    }
}