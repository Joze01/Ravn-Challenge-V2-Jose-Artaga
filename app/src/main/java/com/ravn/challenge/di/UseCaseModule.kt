package com.ravn.challenge.di

import com.ravn.core.usecase.FetchStarWarsPeopleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchStarWarsPeopleUseCase(get()) }
}
