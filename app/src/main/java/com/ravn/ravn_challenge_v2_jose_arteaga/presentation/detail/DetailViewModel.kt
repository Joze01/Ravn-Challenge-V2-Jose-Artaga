package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.detail

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.detail.DetailItemModel
import com.ravn.core.model.util.DetailViewType
import com.ravn.ravn_challenge_v2_jose_arteaga.R
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util.RavnResourceManager

class DetailViewModel(val resourceManager: RavnResourceManager) : ViewModel() {
    val listResult = mutableListOf<DetailItemModel>()

    fun prepareList(peopleModel: PeopleModel) {
        addHeaderToList(
            R.string.detail_item_general_info
        )
        peopleModel.eyeColor?.let {
            addAtributeToList(R.string.detail_item_eye_color, it)
        }
        peopleModel.hairColor?.let {
            addAtributeToList(R.string.detail_item_hair_color, it)
        }
        peopleModel.skinColor?.let {
            addAtributeToList(R.string.detail_item_skin_color, it)
        }
        peopleModel.birthYear?.let {
            addAtributeToList(R.string.detail_item_birth_year, it)
        }
        if (peopleModel?.vehiclesConnection.isNullOrEmpty()) {
            addHeaderToList(
                R.string.detail_item_general_vehicles
            )
            peopleModel.vehiclesConnection?.forEach { vehicle ->
                vehicle.name?.let {
                    addVehicleToList(it)
                }
            }
        }
    }


    fun addAtributeToList(@StringRes stringResId: Int, value: String) {
        listResult.add(
            DetailItemModel(
                DetailViewType.ATRIBUTE,
                Pair(
                    resourceManager.getString(stringResId), value
                )
            )
        )
    }

    fun addHeaderToList(@StringRes stringResId: Int) {
        listResult.add(
            DetailItemModel(
                DetailViewType.HEADER,
                Pair(
                    resourceManager.getString(stringResId), null
                )
            )
        )
    }

    fun addVehicleToList(vehicleName: String) {
        listResult.add(
            DetailItemModel(
                DetailViewType.VEHICLE,
                Pair(
                    vehicleName, null
                )
            )
        )
    }
}