package com.ravn.challenge.presentation.detail

import com.prototype.urbandictionary.util.ViewModelTest
import com.ravn.challenge.presentation.util.RavnResourceManager
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.SpecieModel
import com.ravn.core.model.starwars.VehiclesModel
import org.junit.Test

class DetailViewModelTest : ViewModelTest<DetailViewModel>() {

    private val peopleModelMock = listOf(
        PeopleModel(
            "ID_TEST",
            "LUKE SKYWALKER",
            "RED",
            "PURGLE",
            "GREEN",
            "1994",
            null,
            SpecieModel(id = null, name = ""),
            "",
            false
        ), PeopleModel(
            "ID_TEST",
            "LUKE SKYWALKER",
            "RED",
            "PURGLE",
            "GREEN",
            "1994",
            mutableListOf(VehiclesModel("X Wing", "Model")),
            SpecieModel(id = null, name = ""),
            "",
            false
        )
    )

    override suspend fun buildViewModel(): DetailViewModel =
        DetailViewModel(RavnResourceManager(context))

    @Test
    fun prepareListTest() = safeTest {
        prepareList(peopleModelMock.last())
        assertTrue(listResult.size > 0)
        assertEquals(peopleModelMock.last().eyeColor, listResult[1].itemValue?.second)
    }
}