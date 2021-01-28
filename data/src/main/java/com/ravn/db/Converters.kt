package com.ravn.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ravn.core.model.starwars.SpecieModel
import com.ravn.core.model.starwars.VehiclesModel

class Converters {

    @TypeConverter
    fun fromFormFieldList(value: List<VehiclesModel>?): String? {
        return Gson().toJson(
            if (value.isNullOrEmpty()) {
                listOf()
            } else {
                value
            }
        )
    }

    @TypeConverter
    fun toFormFieldList(value: String?): List<VehiclesModel>? {
        return (Gson().fromJson(
            value,
            Array<VehiclesModel>::class.java
        ) as Array<VehiclesModel>).toList()
    }

    @TypeConverter
    fun fromSpecie(value: SpecieModel?): String =
        Gson().toJson(value)

    @TypeConverter
    fun toSpecie(value: String?): SpecieModel? =
        Gson().fromJson(value, SpecieModel::class.java)
}