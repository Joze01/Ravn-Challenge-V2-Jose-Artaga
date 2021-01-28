package com.ravn.core.usecase

import androidx.annotation.VisibleForTesting
import com.ravn.core.repository.PeopleRepository

class FetchStarWarsPeopleUseCase(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val peopleRepository: PeopleRepository
) {
    operator fun invoke(lastCursor: String?, firstLoad: Boolean) =
        peopleRepository.fetchStarWarsPeople(lastCursor = lastCursor, firstLoad = firstLoad)
}