package com.ravn.core.usecase

import androidx.annotation.VisibleForTesting
import com.ravn.core.repository.PeopleRepository

class getStarWarsPeopleById(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val peopleRepository: PeopleRepository
) {
    suspend operator fun invoke(peopleId: String) = peopleRepository.getStarWarsPeopleById(peopleId)
}