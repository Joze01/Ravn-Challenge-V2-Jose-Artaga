package com.ravn.core.usecase

import androidx.annotation.VisibleForTesting
import com.ravn.core.repository.PeopleRepository

class FetchStarWarsPeopleUseCase(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val peopleRepository: PeopleRepository
) {
    operator fun invoke(pageSize: Int) = peopleRepository.fetchStarWarsPeople(pageSize)
}