package com.example.evabd.navigation

sealed class AppScreens (val route : String){
    object Home : AppScreens(route = "AppAlumnos")
    object AddScreen : AppScreens(route = "AddScreen")
    object Jardin : AppScreens(route = "Jardin")
}
