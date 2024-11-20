package com.parvinder.starwars.data.utils

import com.parvinder.starwars.data.models.MatchPlayerWithScore
import com.parvinder.starwars.data.models.Player
import com.parvinder.starwars.data.models.StarWarCharacter
import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches

fun StarWarCharacter.toCharacterWithMatchData(): StarWarCharacterWithMatches =
    StarWarCharacterWithMatches(
        icon = icon ?: "", id = id, name = name ?: "", 0, 0, 0, 0, emptyList()
    )


fun Player.toMatchPlayer(name: String) =
    MatchPlayerWithScore(playerName = name, playerId = id, score = score ?: 0)