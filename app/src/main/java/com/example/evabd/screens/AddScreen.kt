package com.example.evabd.screens

import com.example.evabd.models.PlantaViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.evabd.models.Planta
import com.example.evabd.navigation.AppScreens
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController) {
    Scaffold (
//        topBar = { TopAppBar {} },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = { navController.navigate(route = AppScreens.Jardin.route) }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Agregar",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
    {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavHostController){
    var foto by remember { mutableStateOf("") }
    var nombreP by remember { mutableStateOf("") }
    var infoP by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        )
        {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = foto,
                onValueChange = {foto = it},
                label = { Text(text = "Foto de la pelicula")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = nombreP,
                onValueChange = {nombreP = it},
                label = { Text(text = "Nombre de la Pelicula")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = infoP,
                onValueChange = {infoP = it},
                label = { Text(text = "Sinopsis de la pelicula")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    val plantas = Planta(foto, nombreP, infoP)
                    Firebase.firestore.collection("plantas").add(plantas)
                    navController.navigate(route = AppScreens.Jardin.route)
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Agregar Pelicula")
            }
            Button(
                onClick = { navController.navigate(route = AppScreens.Jardin.route)},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Regresar")
            }
        }
    }
}
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun PlanticaCard (planta : Planta, navController: NavController) {
//    Scaffold (
////        topBar = { TopAppBar {} },
//        floatingActionButton = {
//            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = {navController.navigate(AppScreens.Jardin.route)}) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Agregar",
//                    tint = Color.White
//                )
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
//    ) {
//        Card(
//            modifier = Modifier
//                .padding(all = 16.dp)
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Image(
//                    painter = rememberAsyncImagePainter(model = "${planta.foto}"),
//                    contentDescription = null,
//                    modifier = Modifier.size(300.dp)
////                horizontalAlignment = Alignment.CenterHorizontally,
////                verticalArrangement = Arrangement.Center
//                )
//                Text(text = "${planta.nombreP}", color = Color.Gray)
//                Text(text = " ${planta.infoP}", color = Color.Gray)
//            }
//        }
//    }
//}

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun Mandar(navController: NavController){
//    Scaffold (
//        topBar = { TopAppBar {} },
//        floatingActionButton = {
//            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = {navController.navigate(AppScreens.Jardin.route)}) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Agregar",
//                    tint = Color.White
//                )
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
//    ){
//
//    }
//}

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun AppMatas(
//    navController: NavController,
//    viewModel : PlantaViewModel
//)
//{
//    Scaffold (
//        topBar = { TopAppBar {} },
//        floatingActionButton = {
//            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = {  }) {
//                Icon(
//                    imageVector = Icons.Default.AddCircle,
//                    contentDescription = "Agregar",
//                    tint = Color.White
//                )
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
//    )
//    {
//        Box(modifier = Modifier.fillMaxSize()){
////            Column(){
//                LazyColumn(){
//                    items(viewModel.plantas.value){planta ->
//                        PlanticaCard(planta, navController)
//                    }
//                }
////            }
//        }
//    }
//}