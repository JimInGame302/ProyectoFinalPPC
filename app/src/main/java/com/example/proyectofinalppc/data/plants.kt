package com.example.proyectofinalppc.data

import androidx.annotation.Keep

@Keep
data class Plants(
    var curiosities: String,
    var fruits: String,
    var ground: String,
    var height: Float,
    var image: String,
    var maduration: Float,
    var name: String,
    var plantCares: String,
    var plantDescription: String,
    var scientificName: String,
    var weather: String,
) {

}
