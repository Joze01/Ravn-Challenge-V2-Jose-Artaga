package com.ravn.challenge.presentation.home.list

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event

class PeopleListItemViewModel(
    val personModel: PeopleModel,
    val mutableLiveData: MutableLiveData<Event<PeopleModel>>
) : ViewModel() {
    val peopleName = ObservableField("")
    val specie = ObservableField("")

    fun bindData() {
        peopleName.set(personModel.name)
        specie.set(personModel.species?.name)
    }

    fun onItemClick() {
        mutableLiveData.postValue(Event(personModel))
    }
}
