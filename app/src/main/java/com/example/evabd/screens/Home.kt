package com.example.evabd.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.evabd.navigation.AppScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun Salir(signOutClicked: () -> Unit){
//    Column {
////        Scaffold(
////            topBar = { TopAppBar {} },
////        ) {
//            Button(
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(top = 15.dp),
//                onClick = { signOutClicked() },
//            ) {
//                Text(text = "Log Out")
//            }
//        }
////    }
//}

@Composable
fun Redirigir(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.6f)
            .padding(top = 60.dp)
    )
    {
        Button(onClick = {navController.navigate(AppScreens.AddScreen.route)}){
            Text(text = "Agregar planta")
        }
    }
}