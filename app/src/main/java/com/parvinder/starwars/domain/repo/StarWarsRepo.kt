package com.parvinder.starwars.domain.repo

import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.utils.Resource

interface StarWarsRepo {

    suspend fun getAllCharacters(): Resource<List<StarWarCharacterWithMatches>>
}