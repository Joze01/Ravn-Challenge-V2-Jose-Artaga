package com.ravn.ravn_challenge_v2_jose_arteaga.di

import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.detail.DetailViewModel
import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModuleModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel() }
}