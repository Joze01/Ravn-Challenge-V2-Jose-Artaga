# Ravn-Challenge-V2-Jose-Artaga

## Setup/Running
1. Clone it and build it
**Myabe will need to run generateApolloSources "./gradlew generateApolloSoruces" is automatic when build but sometimes doesnt run automatically**

## Descripction
Kotlin app list detail using GraphQl and apollo client, with koin. 
this project uses ROOM as cache to load all the data and handle one single request to get the data and then distribuite to the detail view by a shared viewmodel, based on my intepretation of clean architecture.

Query: 
https://pastebin.com/SB6HGaUZ

Sanity Check:
This function used to check code sanity
./gradlew sanityCheck

## Any assumptions
I tried to handle 3 modules, App module handle android framework, Core module is a simple ando kotlin pure module and data as a data access layer to handle cache and networking

## Technologies used
  - Koin (Dependency Injection)
  - Android Databinding
  - Kotlin Coroutines
  - LiveData
  - Room
  - Retrofit
  - Mockito
  - Mockk
  - Robolectric
  - Espresso

## Gift Demo 
https://giphy.com/gifs/lN0BwJkDFkqKcLmxhh/html5
