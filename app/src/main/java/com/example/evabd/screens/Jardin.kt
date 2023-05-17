package com.example.evabd.screens

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.evabd.models.Planta
import com.example.evabd.models.PlantaViewModel
import com.example.evabd.navigation.AppScreens
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun PlantaCard (planta : Planta, navController: NavController) {
//    Button(onClick = {navController.navigate(AppScreens.AddScreen.route)}) {
//
//    }
    Card(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ){
        var expandirTexto by remember{ mutableStateOf(false) }

        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable {expandirTexto = !expandirTexto}){
            Image(
                painter = rememberAsyncImagePainter(model = "${planta.foto}"),
                contentDescription = null,
                modifier = Modifier.size(128.dp).align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Text(text = "${planta.nombreP}", color = Color.White)
            Text(text = " ${planta.infoP}", color = Color.White, maxLines = if(expandirTexto)Int.MAX_VALUE else 1)
        }
    }
}

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun Mandar(navController: NavController){
//    Scaffold (
//        topBar = { TopAppBar {} },
//        floatingActionButton = {
//            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = {navController.navigate(AppScreens.AddScreen.route)}) {
//                Icon(
//                    imageVector = Icons.Default.AddCircle,
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppPlantas(
    navController: NavController,
    viewModel : PlantaViewModel,
)
{
    Scaffold (
//        topBar = { TopAppBar {} },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = { navController.navigate(AppScreens.AddScreen.route)  }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Agregar",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
    {
        Box(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)){
//            Column(){
                LazyColumn(){
                    items(viewModel.plantas.value){planta ->
                        PlantaCard(planta, navController)
                    }
                }
//            }
        }
    }
}