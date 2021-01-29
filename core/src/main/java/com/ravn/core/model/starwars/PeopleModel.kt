package com.ravn.core.model.starwars

data class PeopleModel(
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: MutableList<VehiclesModel>? = null,
    val species: SpecieModel? = null,
    val lastCursor: String = "",
    val hasNextPage: Boolean? = false
)
