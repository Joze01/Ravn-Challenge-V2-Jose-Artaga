package com.ravn.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.SpecieModel
import com.ravn.core.model.starwars.VehiclesModel
import com.ravn.util.mapper.CoreMapper

@Entity
class PeopleEntity(
    @PrimaryKey
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: MutableList<VehiclesModel>? = null,
    val species: SpecieModel? = null
) : CoreMapper<PeopleModel>() {
    override fun toCoreModel() = parse<PeopleModel>(this)

}