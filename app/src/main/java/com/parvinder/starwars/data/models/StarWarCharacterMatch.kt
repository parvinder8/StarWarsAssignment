package com.parvinder.starwars.data.models

data class StarWarCharacterMatch(
    val player1: MatchPlayerWithScore,
    val player2: MatchPlayerWithScore,
    val result: StarWarMatchResultEnum
)