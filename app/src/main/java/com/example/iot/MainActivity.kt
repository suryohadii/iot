package com.example.iot

import android.bluetooth.BluetoothGatt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iot.ui.theme.IotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    kotak1()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 18.sp,
        modifier = modifier
    )
}

@Composable
fun switch (modifier: Modifier = Modifier) {
    var a by remember { mutableStateOf(false) }
    Text(text = "pompa", color = Color.Blue)
    Switch(checked = a, onCheckedChange = {a = it},
        modifier = Modifier.padding(start = 40.dp))

}

@Composable
fun kotak (){
    Box(modifier = Modifier
        .padding(25.dp)
        .clip(
            RoundedCornerShape(
                topStart = 50.dp,
                topEnd = 50.dp,
                bottomStart = 50.dp,
                bottomEnd = 50.dp
            )
        )
        .fillMaxWidth()
        .height(100.dp)
        .width(100.dp)
        .background(color = MaterialTheme.colorScheme.tertiary)

    ){}
}

@Composable
fun BG (){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(bottomStart = 320.dp, bottomEnd = 320.dp))
        .fillMaxWidth()
        .height(300.dp)
        .background(color = MaterialTheme.colorScheme.secondaryContainer)

        ){}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IotTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box {
                BG()
                Column {
                    Greeting("Android")
                    switch()
                }
            }
            kotak()

        }
        }
    }
