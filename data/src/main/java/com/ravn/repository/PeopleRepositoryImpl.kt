package com.ravn.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.repository.PeopleRepository
import com.ravn.db.dao.PeopleDao

class PeopleRepositoryImpl(val peopleDao: PeopleDao) : PeopleRepository {
    override fun fetchStarWarsPeople(pageSize: Int): LiveData<List<PeopleModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStarWarsPeopleById(peopleId: String): PeopleModel =
        peopleDao.getPeopleById(peopleId).toCoreModel()
}