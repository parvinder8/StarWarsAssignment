package com.parvinder.starwars.data.models


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id") val id: Int, @SerializedName("score") val score: Int?
)