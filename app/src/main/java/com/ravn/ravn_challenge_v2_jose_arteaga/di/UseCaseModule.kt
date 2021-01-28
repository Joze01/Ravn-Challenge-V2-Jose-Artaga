package com.ravn.ravn_challenge_v2_jose_arteaga.di

import com.ravn.core.usecase.FetchStarWarsPeopleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchStarWarsPeopleUseCase(get()) }
}