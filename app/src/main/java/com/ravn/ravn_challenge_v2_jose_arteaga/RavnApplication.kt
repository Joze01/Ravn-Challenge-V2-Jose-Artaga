package com.ravn.ravn_challenge_v2_jose_arteaga

import android.app.Application
import com.ravn.di.apiModule
import com.ravn.di.databaseModule
import com.ravn.di.repositoryModule
import com.ravn.ravn_challenge_v2_jose_arteaga.di.useCaseModule
import com.ravn.ravn_challenge_v2_jose_arteaga.di.viewModuleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RavnApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RavnApplication)
            androidLogger()
            modules(appModules())
        }
    }

    /**
     * Koin Modules getter function.
     * Used in the onCreate method by the Koin framework.
     * Open to be overridden by the Test Application class.
     *
     * @return listOf Koin Modules
     */
    open fun appModules() = listOf(
        apiModule,
        databaseModule,
        repositoryModule,
        useCaseModule,
        viewModuleModule,
    )
}