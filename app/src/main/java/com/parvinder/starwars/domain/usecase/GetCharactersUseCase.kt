package com.parvinder.starwars.domain.usecase

import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
    operator fun invoke(): Flow<Resource<List<StarWarCharacterWithMatches>>>
}