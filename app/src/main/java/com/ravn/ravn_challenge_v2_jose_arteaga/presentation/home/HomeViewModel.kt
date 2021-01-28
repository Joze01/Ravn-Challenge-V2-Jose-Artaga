package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import androidx.annotation.VisibleForTesting
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event
import com.ravn.core.model.util.Resource
import com.ravn.core.usecase.FetchStarWarsPeopleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    val fetchStarWarsPeopleUseCase: FetchStarWarsPeopleUseCase
) : ViewModel() {

    // ViewVisible Observables
    val showProgressBar = ObservableBoolean(false)
    val showError = ObservableBoolean(false)
    val showRecyclerView = ObservableBoolean(false)

    //LiveData for recyclerView
    val mutableLiveData = MutableLiveData<Event<List<PeopleModel>>>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var peopleListSource: LiveData<Resource<List<PeopleModel>>> = MutableLiveData()
    val peopleListData = MediatorLiveData<Resource<List<PeopleModel>>>()

    fun fetchData() {
        peopleListData.removeSource(peopleListSource)
            peopleListSource = fetchStarWarsPeopleUseCase.invoke(5)
        peopleListData.addSource(peopleListSource) {
            peopleListData.postValue(it)
        }
    }
}