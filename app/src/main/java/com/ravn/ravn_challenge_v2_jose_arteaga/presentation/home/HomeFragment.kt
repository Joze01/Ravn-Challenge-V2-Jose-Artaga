package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ravn.ravn_challenge_v2_jose_arteaga.R
import com.ravn.ravn_challenge_v2_jose_arteaga.base.BaseFragment
import com.ravn.ravn_challenge_v2_jose_arteaga.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    // We override the base viewModel variable by injecting it via Koin
    override val viewModel: HomeViewModel by viewModel()

    override fun onFragmentReady() {
        Log.wtf("JAAC", "HOME FRAGMENTREADY")
    }
}
