package com.example.proyectofinalppc.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.proyectofinalppc.data.Plants
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseRepository @Inject constructor() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getDocuments(callback: (List<Plants>) -> Unit) {
        val plantsList = mutableListOf<Plants>()

        db.collection("plants")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val plant = Plants(
                            document["curiosities"] as String,
                            document["fruits"] as String,
                            document["ground"] as String,
                            (document["height"] as Number).toFloat(),
                            document["image"] as String,
                            (document["maduration"] as Number).toInt(),
                            document["name"] as String,
                            document["plantCares"] as String,
                            document["plantDescription"] as String,
                            document["scientificName"] as String,
                            document["weather"] as String
                        )
                        plantsList.add(plant)
                        Log.d(TAG, plant.name)
                    }
                    callback(plantsList)
                } else {
                    Log.w(TAG, "Error obteniendo documentos.", task.exception)
                    callback(emptyList())
                }
            }
    }
}