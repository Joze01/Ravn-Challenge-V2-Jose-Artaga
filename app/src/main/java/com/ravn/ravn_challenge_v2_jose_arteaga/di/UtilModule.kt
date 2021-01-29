package com.ravn.ravn_challenge_v2_jose_arteaga.di

import com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util.RavnResourceManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
    single { RavnResourceManager(androidContext()) }
}