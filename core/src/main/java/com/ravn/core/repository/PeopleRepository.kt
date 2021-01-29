package com.ravn.core.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Resource

interface PeopleRepository {

    fun fetchStarWarsPeople(
        pageSize: Int = DEFAULT_PAGE_SIZE,
        lastCursor: String? = DEFAULT_CURSOR,
        firstLoad: Boolean = false
    ): LiveData<Resource<List<PeopleModel>>>

    companion object {
        const val DEFAULT_PAGE_SIZE = 5
        const val DEFAULT_CURSOR = ""
    }
}
