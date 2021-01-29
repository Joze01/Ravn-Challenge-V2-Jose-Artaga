package com.ravn.challenge.di

import com.ravn.challenge.presentation.util.RavnResourceManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
    single { RavnResourceManager(androidContext()) }
}
