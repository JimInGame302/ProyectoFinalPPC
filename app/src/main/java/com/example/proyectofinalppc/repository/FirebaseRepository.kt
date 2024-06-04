package com.example.proyectofinalppc.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseRepository @Inject constructor(){

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getDocuments() {
        db.collection("plants")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                } else {
                    Log.w(TAG, "Error obteniendo documentos.", task.exception)
                }
            }
    }

}