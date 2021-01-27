package com.ravn.core.model.starwars

data class PersonModel(
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: MutableList<VehiclesModel>? = null,
    val species: SpecieModel? = null
)