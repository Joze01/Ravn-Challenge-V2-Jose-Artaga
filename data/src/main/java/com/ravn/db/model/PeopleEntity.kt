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
    var id: String,
    var name: String? = null,
    var eyeColor: String? = null,
    var hairColor: String? = null,
    var skinColor: String? = null,
    var birthYear: String? = null,
    var vehiclesConnection: MutableList<VehiclesModel>? = null,
    var species: SpecieModel? = null,
    val lastCursor: String = "",
    val hasNextPage: Boolean? = false
) : CoreMapper<PeopleModel>() {
    override fun toCoreModel() = parse<PeopleModel>(this)
}
