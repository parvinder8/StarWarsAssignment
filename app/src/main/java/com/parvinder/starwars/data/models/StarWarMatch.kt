package com.parvinder.starwars.data.models


import com.google.gson.annotations.SerializedName

data class StarWarMatch(
    @SerializedName("match") val match: Int?,
    @SerializedName("player1") val player1: Player,
    @SerializedName("player2") val player2: Player
)