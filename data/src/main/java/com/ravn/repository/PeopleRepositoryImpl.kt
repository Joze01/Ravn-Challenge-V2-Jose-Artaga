package com.ravn.repository

import androidx.lifecycle.LiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.ravn.AllPeopleListQuery
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Resource
import com.ravn.core.repository.PeopleRepository
import com.ravn.db.dao.PeopleDao
import com.ravn.db.model.PeopleEntity
import com.ravn.util.NetworkBoundResource


class PeopleRepositoryImpl(
    val peopleDao: PeopleDao, val apolloClient: ApolloClient

) : PeopleRepository {
    override fun fetchStarWarsPeople(pageSize: Int): LiveData<Resource<List<PeopleModel>>> =
        NetworkBoundResource.create(
            query = {
                peopleDao.getPeople().map {
                    it.toCoreModel()
                }
            },
            fetch = { dbResult ->
                try {
                    val data = apolloClient.query(AllPeopleListQuery()).await()

                    val result: MutableList<PeopleEntity> = mutableListOf()
                    data.data?.allPeople?.people?.forEach { person ->
                        person?.let {
                            val entity = PeopleEntity(
                                id = it.id,
                                name = it.name,
                                eyeColor = it.eyeColor,
                                hairColor = it.hairColor,
                                skinColor = it.skinColor,
                                birthYear = it.birthYear
                            )
                            result.add(entity)
                        }
                    }
                    result
                } catch (ex: ApolloException) {
                    emit(Resource.error(ex, dbResult))
                    null
                }
            },
            saveFetchResult = { response ->
                val response =
                    peopleDao.savePeople(response)
            }
        )


    override suspend fun getStarWarsPeopleById(peopleId: String): PeopleModel =
        peopleDao.getPeopleById(peopleId).toCoreModel()
}