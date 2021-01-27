package com.ravn.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.starwars.PersonModel

interface PeopleRepository {

    fun fetchStarWarsPeople(pageSize: Int = DEFAULT_PAGE_SIZE): LiveData<List<PersonModel>>

    fun getStarWarsPeopleById(personId: String): PersonModel

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}