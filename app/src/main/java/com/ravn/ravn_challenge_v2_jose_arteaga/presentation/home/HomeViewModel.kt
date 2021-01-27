package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PersonModel
import com.ravn.core.model.util.Event

class HomeViewModel : ViewModel() {

    // ViewVisible Observables
    val showProgressBar = ObservableBoolean(false)
    val showError = ObservableBoolean(false)
    val showRecyclerView = ObservableBoolean(false)

    //LiveData for recyclerView
    val mutableLiveData = MutableLiveData<Event<List<PersonModel>>>()
}