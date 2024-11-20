package com.parvinder.starwars.data.models


import com.google.gson.annotations.SerializedName

data class StarWarCharacter(
    @SerializedName("icon") val icon: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?
)