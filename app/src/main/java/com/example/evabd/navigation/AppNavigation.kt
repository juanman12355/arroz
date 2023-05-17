package com.example.evabd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evabd.models.PlantaViewModel
//import com.example.evabd.screens.AppMatas
import com.example.evabd.screens.AppPlantas
import com.example.evabd.screens.BodyContent
import com.example.evabd.screens.Redirigir

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Jardin.route){
        composable(route = AppScreens.Jardin.route){ AppPlantas(navController, PlantaViewModel()) }
        composable(route = AppScreens.Home.route){ Redirigir(navController) }
        composable(route = AppScreens.AddScreen.route){ BodyContent(navController) }
    }
}