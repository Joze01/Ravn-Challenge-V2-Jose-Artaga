package com.ravn.challenge.presentation.home

import androidx.lifecycle.MutableLiveData
import com.prototype.urbandictionary.util.FragmentTest
import com.ravn.challenge.presentation.SharedViewModel
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.SpecieModel
import com.ravn.core.model.util.Resource
import org.junit.Test
import org.koin.androidx.viewmodel.dsl.viewModel

// This is how the FragmentTest class is used
class HomeFragmentTest : FragmentTest<HomeFragment>() {

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
        )
    )

    override fun assignClass() = makeClass<HomeFragment>()

    override suspend fun injectFragment() {
        val viewModel = HomeViewModel(mock())
        val shareViewModel = SharedViewModel()

        on(viewModel.fetchStarWarsPeopleUseCase.invoke(any(), any()))
            .thenReturn(MutableLiveData(Resource.success(peopleModelMock)))

        injectModule {
            viewModel { viewModel }
            viewModel { shareViewModel }
        }
    }

    @Test
    fun peopleObserverSuccessTest() = safeTest {
        assertEquals(peopleModelMock.size, peopleListAdapter.itemCount)
    }
}