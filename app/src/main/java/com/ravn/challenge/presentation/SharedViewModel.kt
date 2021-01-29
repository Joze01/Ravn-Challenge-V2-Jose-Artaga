package com.ravn.challenge.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PeopleModel

class SharedViewModel : ViewModel() {
    var peopleModel = PeopleModel("")
}
