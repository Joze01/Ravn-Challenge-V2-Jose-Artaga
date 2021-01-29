package com.ravn.challenge.presentation.detail

import androidx.test.core.app.ApplicationProvider
import com.prototype.urbandictionary.util.FragmentTest
import com.ravn.challenge.presentation.SharedViewModel
import com.ravn.challenge.presentation.util.RavnResourceManager
import com.ravn.challenge.test.TestApp
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.starwars.SpecieModel
import org.junit.Test
import org.koin.androidx.viewmodel.dsl.viewModel

// This is how the FragmentTest class is used
class DetailFragmentTest : FragmentTest<DetailFragment>() {

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

    override fun assignClass() = makeClass<DetailFragment>()

    override suspend fun injectFragment() {
        val shareViewModel = SharedViewModel()
        context = ApplicationProvider.getApplicationContext<TestApp>()
        val ravnResourceManager = RavnResourceManager(context)
        val viewModel = DetailViewModel(ravnResourceManager)

        injectModule {
            viewModel { viewModel }
            viewModel { shareViewModel }
        }
    }

    @Test
    fun prepareRecyclerViewTest() = safeTest {
        sharedViewModel.peopleModel = peopleModelMock.first()
        viewModel.prepareList(sharedViewModel.peopleModel)
        prepareRecyclerView()
        assertTrue(detailListAdapter.itemCount > 0)
    }
}