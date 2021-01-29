package com.ravn.challenge.di

import com.ravn.challenge.presentation.SharedViewModel
import com.ravn.challenge.presentation.detail.DetailViewModel
import com.ravn.challenge.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModuleModule = module {
    viewModel { SharedViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
