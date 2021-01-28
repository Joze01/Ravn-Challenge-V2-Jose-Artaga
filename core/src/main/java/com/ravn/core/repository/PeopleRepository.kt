package com.ravn.core.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.starwars.PeopleModel

interface PeopleRepository {

    fun fetchStarWarsPeople(pageSize: Int = DEFAULT_PAGE_SIZE): LiveData<List<PeopleModel>>

    suspend fun getStarWarsPeopleById(peopleId: String): PeopleModel

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}