package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import androidx.annotation.VisibleForTesting
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event
import com.ravn.core.model.util.Resource
import com.ravn.core.usecase.FetchStarWarsPeopleUseCase

class HomeViewModel(
    val fetchStarWarsPeopleUseCase: FetchStarWarsPeopleUseCase
) : ViewModel() {

    // ViewVisible Observables
    val showError = ObservableBoolean(false)

    //LiveData for recyclerView
    val mutableLiveData = MutableLiveData<Event<List<PeopleModel>>>()
    val itemClick = MutableLiveData<Event<PeopleModel>>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var peopleListSource: LiveData<Resource<List<PeopleModel>>> = MutableLiveData()
    val peopleListData = MediatorLiveData<Resource<List<PeopleModel>>>()

    fun fetchData(lastCursor: String? = "", firstLoad: Boolean = false) {
        peopleListData.removeSource(peopleListSource)
        peopleListSource = fetchStarWarsPeopleUseCase.invoke(lastCursor, firstLoad)
        peopleListData.addSource(peopleListSource) {
            peopleListData.postValue(it)
        }
    }


}