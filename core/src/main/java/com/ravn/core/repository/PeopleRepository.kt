package com.ravn.core.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Resource

interface PeopleRepository {

     fun fetchStarWarsPeople(pageSize: Int = DEFAULT_PAGE_SIZE): LiveData<Resource<List<PeopleModel>>>

    suspend fun getStarWarsPeopleById(peopleId: String): PeopleModel

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
    }
}