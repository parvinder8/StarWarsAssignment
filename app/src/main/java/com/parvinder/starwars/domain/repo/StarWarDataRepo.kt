package com.parvinder.starwars.domain.repo

import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.utils.Resource

interface StarWarDataRepo {
    suspend fun createDataWithMatches(): Resource<List<StarWarCharacterWithMatches>>
}