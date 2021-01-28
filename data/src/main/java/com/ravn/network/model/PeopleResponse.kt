package com.ravn.network.model

import com.ravn.db.model.PeopleEntity
import com.ravn.util.mapper.RoomMapper

data class PeopleResponse(
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: MutableList<VehiclesResponse>? = null,
    val species: MutableList<SpecieResponse>? = null
) : RoomMapper<PeopleEntity>() {
    override fun toRoomEntity() = parse<PeopleEntity>(this)
}