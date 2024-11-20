package com.parvinder.starwars.data.repo

import android.util.Log
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.repo.StarWarDataRepo
import com.parvinder.starwars.domain.repo.StarWarsRepo
import com.parvinder.starwars.domain.utils.Resource
import javax.inject.Inject

class StarWarsRepoImpl @Inject constructor(private val starWarDataRepo: StarWarDataRepo) :
    StarWarsRepo {
    override suspend fun getAllCharacters(): Resource<List<StarWarCharacterWithMatches>> {
        Log.d("PointTableScreen1: ",starWarDataRepo.createDataWithMatches().toString())

        return starWarDataRepo.createDataWithMatches()
    }
}