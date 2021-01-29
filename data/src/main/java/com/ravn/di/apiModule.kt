package com.ravn.di

import com.apollographql.apollo.ApolloClient
import org.koin.dsl.module

val apiModule = module {
    single {
        ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .build()
    }
}

const val SERVER_URL = "https://swapi-graphql.netlify.app/.netlify/functions/index"
