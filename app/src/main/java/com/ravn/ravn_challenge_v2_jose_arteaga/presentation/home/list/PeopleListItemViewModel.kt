package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home.list

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event

class PeopleListItemViewModel(
    val personModel: PeopleModel,
    val mutableLiveData: MutableLiveData<Event<String>>
) : ViewModel() {
    val peopleName = ObservableField("")
    val specie = ObservableField("")

    init {
        peopleName.set(personModel.name)
        specie.set(personModel.species?.name)
    }

    fun onItemClick() {
        mutableLiveData.postValue(Event(personModel.id))
    }
}