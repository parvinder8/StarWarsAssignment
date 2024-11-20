package com.parvinder.starwars.data.repo

import android.content.Context
import android.util.Log
import com.parvinder.starwars.data.models.Player
import com.parvinder.starwars.data.models.StarWarCharacterList
import com.parvinder.starwars.data.models.StarWarCharacterMatch
import com.parvinder.starwars.data.models.StarWarMatchList
import com.parvinder.starwars.data.models.StarWarMatchResultEnum
import com.parvinder.starwars.data.utils.FileReadTypeEnum
import com.parvinder.starwars.data.utils.FileReaderUtil
import com.parvinder.starwars.data.utils.toCharacterWithMatchData
import com.parvinder.starwars.data.utils.toMatchPlayer
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches
import com.parvinder.starwars.domain.repo.StarWarDataRepo
import com.parvinder.starwars.domain.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StarWarDataRepoImpl @Inject constructor(@ApplicationContext val context: Context) :
    StarWarDataRepo {
    override suspend fun createDataWithMatches(): Resource<List<StarWarCharacterWithMatches>> {
        val mapData = mutableMapOf<Int, StarWarCharacterWithMatches>()
        val characters = try {
            FileReaderUtil.readFromJson(
                context, FileReadTypeEnum.CHARACTERS
            ) as? StarWarCharacterList ?: emptyList()
        } catch (e: Exception) {
            return Resource.Error(e.message ?: e.localizedMessage ?: "")
        }
        val matches = try {
            FileReaderUtil.readFromJson(context, FileReadTypeEnum.MATCHES) as? StarWarMatchList
                ?: emptyList()
        } catch (e: Exception) {
            return Resource.Error(e.message ?: e.localizedMessage ?: "")
        }
        for (c in characters) {
            mapData[c.id] = c.toCharacterWithMatchData()
        }

        for (m in matches) {
            mapData[m.player1.id] = mapData[m.player1.id].let {
                updatePlayerData(it, m.player1, m.player2, mapData.toMap())
            }
            mapData[m.player2.id] = mapData[m.player2.id].let {
                updatePlayerData(it, m.player2, m.player1, mapData.toMap())
            }
        }
        Log.d("PointTableScreen2: ",mapData.values.toString())

        return Resource.Success(mapData.values.toList())

    }

    private fun updatePlayerData(
        it: StarWarCharacterWithMatches?,
        playerOne: Player,
        playerTwo: Player,
        playerMap: Map<Int, StarWarCharacterWithMatches>
    ): StarWarCharacterWithMatches {
        val playerOneScore = getScore(playerOne, playerTwo)
        val playerTwoScore = getScore(playerTwo, playerOne)
        val playerOneName = playerOne.toMatchPlayer(playerMap[playerOne.id]?.name ?: "")
        val playerTwoName = playerTwo.toMatchPlayer(playerMap[playerTwo.id]?.name ?: "")
        val match = StarWarCharacterMatch(
            player1 = playerOneName, player2 = playerTwoName, result = playerOneScore
        )
        val matches = it?.matches?.toMutableList() ?: mutableListOf()
        matches.add(match)
        return it!!.copy(
            totalMatches = it.totalMatches + 1,
            points = it.points + playerOneScore.value,
            winMatches = it.winMatches.plus(if (playerOneScore.value > playerTwoScore.value) 1 else 0),
            tieMatches = it.tieMatches.plus(if (playerOneScore.value == playerTwoScore.value) 1 else 0),
            matches = matches.toList()
        )
    }

    private fun getScore(p1: Player, p2: Player): StarWarMatchResultEnum {
        return when {
            p1.score == p2.score -> StarWarMatchResultEnum.DRAW
            (p1.score ?: 0) > (p2.score ?: 0) -> StarWarMatchResultEnum.WIN
            else -> StarWarMatchResultEnum.LOSS
        }
    }
}

