package com.ravn.repository

import androidx.lifecycle.LiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.ravn.AllPeopleListQuery
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.SpecieModel
import com.ravn.core.model.starwars.VehiclesModel
import com.ravn.core.model.util.Resource
import com.ravn.core.repository.PeopleRepository
import com.ravn.db.dao.PeopleDao
import com.ravn.db.model.PeopleEntity
import com.ravn.util.NetworkBoundResource

class PeopleRepositoryImpl(
    val peopleDao: PeopleDao,
    val apolloClient: ApolloClient

) : PeopleRepository {
    override fun fetchStarWarsPeople(
        pageSize: Int,
        lastCursor: String?,
        firstLoad: Boolean
    ): LiveData<Resource<List<PeopleModel>>> =
        NetworkBoundResource.create(
            // Can handle logic to get data only from the cache for this example will be always true
            shouldFetch = {
                true
            },
            query = {
                peopleDao.getPeople().map {
                    it.toCoreModel()
                }
            },
            fetch = { dbResult ->
                try {
                    val data = apolloClient.query(
                        AllPeopleListQuery(
                            pageSize = pageSize,
                            cursor = lastCursor ?: ""
                        )
                    ).await()

                    val result: MutableList<PeopleEntity> = mutableListOf()
                    data.data?.allPeople?.people?.forEach { person ->
                        person?.let {
                            val vehicles = mutableListOf<VehiclesModel>()
                            it.vehicleConnection?.vehicles?.forEach { vehicle ->
                                vehicles.add(VehiclesModel(vehicle?.name, vehicle?.model))
                            }
                            val entity = PeopleEntity(
                                id = it.id,
                                name = it.name,
                                eyeColor = it.eyeColor,
                                hairColor = it.hairColor,
                                skinColor = it.skinColor,
                                birthYear = it.birthYear,
                                vehiclesConnection = vehicles,
                                species = SpecieModel(it.species?.id, it.species?.name),
                                lastCursor = data.data?.allPeople?.pageInfo?.endCursor ?: "",
                                hasNextPage = data.data?.allPeople?.pageInfo?.hasNextPage
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
                if (firstLoad) {
                    peopleDao.clearPeople()
                }
                peopleDao.savePeople(response)
            }
        )
}
