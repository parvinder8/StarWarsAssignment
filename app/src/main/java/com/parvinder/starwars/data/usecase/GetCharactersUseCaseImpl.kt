package com.parvinder.starwars.data.usecase

import android.util.Log
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.repo.StarWarsRepo
import com.parvinder.starwars.domain.usecase.GetCharactersUseCase
import com.parvinder.starwars.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCaseImpl @Inject constructor(private val starWarsRepo: StarWarsRepo) :
    GetCharactersUseCase {
    override fun invoke(): Flow<Resource<List<StarWarCharacterWithMatches>>> {
        return flow {
            when (val res = starWarsRepo.getAllCharacters()) {
                is Resource.Success -> {
                    Log.d("PointTableScreen3: ",res.data.toString())
                    emit(Resource.Success(sortList(res.data)))
                }
                else -> emit(res)
            }
        }
    }

    private fun sortList(data: List<StarWarCharacterWithMatches>) : List<StarWarCharacterWithMatches>{
        val sortedList=  data.sortedWith { a, b ->
            when {
                a.points != b.points -> b.points.compareTo(a.points)
                else -> b.totalMatches.compareTo(a.totalMatches)
            }
        }.toList()
        Log.d("PointTableScreen10: ",sortedList.toString())

        return sortedList
    }
}
