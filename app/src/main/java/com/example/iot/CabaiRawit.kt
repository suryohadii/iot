package com.example.iot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iot.ui.theme.IotTheme
import com.example.iot.ui.theme.md_theme_dark_error
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

@Composable
fun kotak1 (){
    var avgPhTanah by remember { mutableStateOf(0.0f) }
    var ph1 by remember { mutableStateOf(0.0f) }
    var ph2 by remember { mutableStateOf(0.0f) }
    var avgsoil by remember { mutableStateOf(0.0f) }
    var soil1 by remember { mutableStateOf(0.0f) }
    var soil2 by remember { mutableStateOf(0.0f) }
    LaunchedEffect(Unit){
        val database: FirebaseDatabase = FirebaseDatabase.getInstance("https://cabai-f6c80-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val avgpHRef = database.getReference("pHtanah/average")
        val ph1Ref = database.getReference("pHtanah/pH1")
        val ph2Ref = database.getReference("pHtanah/pH2")
        val avgsoilRef = database.getReference("soilmoisture/average")
        val soil1Ref = database.getReference("soilmoisture/soil1")
        val soil2Ref = database.getReference("soilmoisture/soil2")


        ph1Ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                ph1 = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        ph2Ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                ph2 = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        avgpHRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                avgPhTanah = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        avgsoilRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                avgsoil = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        soil1Ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                soil1 = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        soil2Ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Float::class.java)
                soil2 = value ?: 0.0f
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    IotTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 50.dp)

            ){
                logo()
                kotak2()
                Spacer(modifier = Modifier.height(21.dp))
                kotak3(average = avgPhTanah, ph1 = ph1, ph2 = ph2, average2 = avgsoil, soil1 = soil1, soil2 = soil2)
                Spacer(modifier = Modifier.height(30.dp))
                control()
                Spacer(modifier = Modifier.height(10.dp))
                switch()
                Spacer(modifier = Modifier.height(5.dp))
                switch1()
                Spacer(modifier = Modifier.height(5.dp))
                switch2()
            }
        }
    }

}

@Composable
fun logo(){
    Row (
        modifier = Modifier
            .padding(start = 20.dp)
            .fillMaxWidth()
    ){
        Text(text = "CR 2024",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.width(160.dp))
        Image(painter = painterResource(id =R.drawable.unair), contentDescription ="",
            modifier = Modifier.size(60.dp))
    }
}

@Composable
fun kotak2 (){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(25))
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(10.dp)


    ){
    Column (
        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
    ){
        Text(text = "Aplikasi",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Monitoring",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .padding(25.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.smartphone),
                contentDescription = "",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop)
        }
        
    }
}
@Composable
fun kotak3 (
    average: Float? = 0.2f,
    ph1: Float? = 0.2f,
    ph2: Float = 0.2f,
    average2: Float = 0.2f,
    soil1: Float = 0.2f,
    soil2: Float = 0.2f
){
        Row (
            modifier = Modifier.
            fillMaxWidth()
        ){
            Box(modifier = Modifier
                .width(150.dp)
                .clip(RoundedCornerShape(20))
                .background(MaterialTheme.colorScheme.primaryContainer)){
                Column(modifier = Modifier.padding(16.dp)){
                    Row {
                        Column {
                            Text(text = "Average",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", average)}")
                        }
                        Spacer(modifier = Modifier.width(15.dp))
                        Image(painter = painterResource(id =R.drawable.phmeter), contentDescription ="",
                            modifier = Modifier.size(40.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Column {
                            Text(text = "Ph 1",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", ph1)}")
                        }
                        Spacer(modifier = Modifier.width(30.dp))
                        Column {
                            Text(text = "Ph 2",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", ph2)}")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .width(190.dp)
                .clip(RoundedCornerShape(20))
                .background(MaterialTheme.colorScheme.tertiaryContainer)){
                Column(modifier = Modifier.padding(16.dp)){
                    Row {
                        Column {
                            Text(text = "Average",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", average2)}%")
                        }
                        Spacer(modifier = Modifier.width(30.dp))
                        Image(painter = painterResource(id =R.drawable.moisturemeter), contentDescription ="",
                            modifier = Modifier.size(40.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Column {
                            Text(text = "Soil 1",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", soil1)}%")
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column {
                            Text(text = "soil 2",
                                fontWeight = FontWeight.Bold)
                            Text(text = "${String.format("%.2f", soil2)}%")
                        }
                    }
                }
            }
        }

    }

@Composable
fun control (){
    Row (
        modifier = Modifier
            .padding(start = 20.dp)
            .fillMaxWidth()
    ){
        Text(text = "Control",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp)
    }
}

@Composable
fun switch (){
    var status by remember {mutableStateOf(false)}

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .background(if (status) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.errorContainer)
        .clip(RoundedCornerShape(25))
        .clickable {
            status = !status
            val database: FirebaseDatabase =
                FirebaseDatabase.getInstance("https://cabai-f6c80-default-rtdb.asia-southeast1.firebasedatabase.app/")
            val ref = database.getReference("pompa/1")
            if (status) {
                ref.setValue(status)
            } else {
                ref.setValue(false)
            }
        }
    ){
        Column(Modifier.padding(4.dp)) {
            Row (
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "1",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                        .width(5.dp)
                        .background(md_theme_dark_error)
                        .clip(RoundedCornerShape(40))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "POMPA AIR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = if (status) "(ON)" else "(OFF)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,)
            }
        }
    }
}

@Composable
fun switch1 (){
    var status by remember {mutableStateOf(false)}
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .background(if (status) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.errorContainer)
        .clip(RoundedCornerShape(25))
        .clickable {
            status = !status
            val database: FirebaseDatabase =
                FirebaseDatabase.getInstance("https://cabai-f6c80-default-rtdb.asia-southeast1.firebasedatabase.app/")
            val ref = database.getReference("pompa/2")
            if (status) {
                ref.setValue(status)
            } else {
                ref.setValue(false)
            }
        }
    ){
       Column (Modifier.padding(4.dp)){
           Row (
               modifier = Modifier,
               horizontalArrangement = Arrangement.Center,
               verticalAlignment = Alignment.CenterVertically
           ){
               Text(
                   text = "2",
                   fontWeight = FontWeight.Bold,
                   fontSize = 19.sp,
               )
               Spacer(modifier = Modifier.width(10.dp))
               Spacer(
                   modifier = Modifier
                       .height(30.dp)
                       .width(5.dp)
                       .background(md_theme_dark_error)
                       .clip(RoundedCornerShape(40))
               )
               Spacer(modifier = Modifier.width(10.dp))
               Text(
                   text = "POMPA AIR POC",
                   fontWeight = FontWeight.Bold,
                   fontSize = 19.sp,
               )
               Spacer(modifier = Modifier.width(56.dp))
               Text(
                   text = if (status) "(ON)" else "(OFF)",
                   fontWeight = FontWeight.Bold,
                   fontSize = 19.sp,)
           }
       }
    }
}

@Composable
fun switch2 (){
    var status by remember {mutableStateOf(false)}
    Box(modifier = Modifier
        .padding(start = 75.dp, top = 10.dp)
        .width(220.dp)
        .background(if (status) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.errorContainer)
        .clip(RoundedCornerShape(25))
        .clickable {
            status = !status
            val database: FirebaseDatabase =
                FirebaseDatabase.getInstance("https://cabai-f6c80-default-rtdb.asia-southeast1.firebasedatabase.app/")
            val ref = database.getReference("pompa/auto")
            if (status) {
                ref.setValue(status)
            } else {
                ref.setValue(false)
            }
        }
    ){
        Column (Modifier.padding(4.dp)){
            Row (
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "AUTO",
                    modifier = Modifier.padding(start = 12.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                )
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = if (status) "(ON)" else "(OFF)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun cabai() {

    kotak1()

}


