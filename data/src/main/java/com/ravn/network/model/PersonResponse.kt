package com.ravn.network.model

data class PersonResponse(
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: MutableList<VehiclesResponse>? = null,
    val species: MutableList<EspecieResponse>? = null
)