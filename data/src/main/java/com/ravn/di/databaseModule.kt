package com.ravn.di

import androidx.room.Room
import com.ravn.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }

    factory {
        (get() as AppDatabase).peopleDao()
    }
}

const val DB_NAME = "ravn_challenge_db"
