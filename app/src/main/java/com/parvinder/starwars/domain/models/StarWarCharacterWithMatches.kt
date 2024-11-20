package com.parvinder.starwars.domain.models

import com.parvinder.starwars.data.models.StarWarCharacterMatch

data class StarWarCharacterWithMatches(
    val icon: String,
    val id: Int,
    val name: String,
    val points: Int,
    val totalMatches: Int,
    val winMatches: Int,
    val tieMatches: Int,
    val matches : List<StarWarCharacterMatch>
)