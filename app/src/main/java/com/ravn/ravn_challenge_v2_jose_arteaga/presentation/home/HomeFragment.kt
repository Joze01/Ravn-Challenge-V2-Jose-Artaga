package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event
import com.ravn.core.model.util.Resource
import com.ravn.ravn_challenge_v2_jose_arteaga.R
import com.ravn.ravn_challenge_v2_jose_arteaga.base.BaseFragment
import com.ravn.ravn_challenge_v2_jose_arteaga.databinding.FragmentHomeBinding
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.SharedViewModel
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home.list.PeopleListAdapter
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util.setObserver
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    // We override the base viewModel variable by injecting it by Koin
    override val viewModel: HomeViewModel by viewModel()
    val sharedViewModel: SharedViewModel by sharedViewModel()
    lateinit var peopleListAdapter: PeopleListAdapter

    override fun onFragmentReady() {
        viewModel.fetchData(firstLoad = true)
        viewModel.peopleListData.setObserver(viewLifecycleOwner, ::peopleObserver)
        viewModel.itemClick.setObserver(viewLifecycleOwner, ::itemClickEvent)
        initRecyclerView()
    }

    fun peopleObserver(resource: Resource<List<PeopleModel>>) {
        when (resource.status) {
            Resource.Status.SUCCESS -> {
                resource.data?.let {
                    if (it.last().hasNextPage == true) {
                        viewModel.fetchData(lastCursor = it.last().lastCursor, firstLoad = false)
                    }
                    peopleListAdapter.setData(it)
                }
                peopleListAdapter.hideProgressBar()
                viewModel.showError.set(false)
            }
            Resource.Status.LOADING -> {
                viewModel.showError.set(false)
                peopleListAdapter.showProgressBar()
            }
            Resource.Status.ERROR -> {
                viewModel.showError.set(true)
                peopleListAdapter.hideProgressBar()

            }
        }
    }

    fun itemClickEvent(itemClicked: Event<PeopleModel>) {
        itemClicked.getContentIfNotHandled()?.let {
            sharedViewModel.peopleModel = it
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            )
        }
    }

    fun initRecyclerView() {
        peopleListAdapter = PeopleListAdapter(itemClick = viewModel.itemClick)
        peopleListAdapter.setHasStableIds(true)
        binding.rvPeople.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPeople.adapter = peopleListAdapter
        binding.rvPeople.itemAnimator = null
    }
}
