package com.example.evabd.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class PlantaViewModel : ViewModel() {
    private val _plantas = mutableStateOf<List<Planta>>(emptyList())
    val plantas : State<List<Planta>>
        get() = _plantas
    private val query = Firebase.firestore.collection("plantas")
    init{
        query.addSnapshotListener {value, _ ->
            if(value != null){
                _plantas.value = value.toObjects()
            }
        }
    }
}