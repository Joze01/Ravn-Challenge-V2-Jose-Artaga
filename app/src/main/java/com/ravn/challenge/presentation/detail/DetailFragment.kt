package com.ravn.challenge.presentation.detail

import androidx.recyclerview.widget.LinearLayoutManager
import com.ravn.challenge.R
import com.ravn.challenge.base.BaseFragment
import com.ravn.challenge.databinding.FragmentDetailBinding
import com.ravn.challenge.presentation.SharedViewModel
import com.ravn.challenge.presentation.detail.list.DetailListAdapter
import com.ravn.challenge.presentation.util.setObserver
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    // We override the base viewModel variable by injecting it via Koin
    override val viewModel: DetailViewModel by viewModel()
    val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onFragmentReady() {
        viewModel.screenTittle.set(sharedViewModel.peopleModel.name)
        viewModel.prepareList(sharedViewModel.peopleModel)
        prepareRecyclerView()

        viewModel.backButtonClickEvent.setObserver(viewLifecycleOwner, ::backPressObserver)
    }

    fun prepareRecyclerView() {
        binding.rvDetail.adapter = DetailListAdapter(viewModel.listResult)
        binding.rvDetail.layoutManager = LinearLayoutManager(requireContext())
        viewModel.progressBarVisible.set(false)
    }

    fun backPressObserver(value: Any) {
        requireActivity().onBackPressed()
    }
}
