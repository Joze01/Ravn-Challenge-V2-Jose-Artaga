package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import android.util.Log
import androidx.lifecycle.Observer
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Resource
import com.ravn.ravn_challenge_v2_jose_arteaga.R
import com.ravn.ravn_challenge_v2_jose_arteaga.base.BaseFragment
import com.ravn.ravn_challenge_v2_jose_arteaga.databinding.FragmentHomeBinding
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util.setObserver
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    // We override the base viewModel variable by injecting it via Koin
    override val viewModel: HomeViewModel by viewModel()

    override fun onFragmentReady() {
        viewModel.fetchData()
        viewModel.peopleListData?.setObserver(viewLifecycleOwner,::peopleObserver)
    }

    fun peopleObserver(resource: Resource<List<PeopleModel>>){
        Log.wtf("JAAC",resource.data.toString())
    }
}
