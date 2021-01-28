package com.ravn.di

import com.apollographql.apollo.ApolloClient
import org.koin.dsl.module

val apiModule = module {
    single {
        ApolloClient.builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .build()
    }
}