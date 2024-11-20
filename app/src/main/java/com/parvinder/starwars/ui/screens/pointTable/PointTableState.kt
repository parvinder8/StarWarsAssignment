package com.parvinder.starwars.ui.screens.pointTable

import com.parvinder.starwars.domain.models.StarWarCharacterWithMatches

data class PointTableState(val list: List<StarWarCharacterWithMatches> = emptyList())