package com.parvinder.starwars.data.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.parvinder.starwars.R
import com.parvinder.starwars.data.models.StarWarCharacterList
import com.parvinder.starwars.data.models.StarWarMatchList

object FileReaderUtil {

    fun readFromJson(context: Context, type: FileReadTypeEnum): Any {
        val fileId = when (type) {
            FileReadTypeEnum.CHARACTERS -> R.raw.characters
            FileReadTypeEnum.MATCHES -> R.raw.matches
        }
        val dataType = when (type) {
            FileReadTypeEnum.CHARACTERS -> StarWarCharacterList::class.java
            FileReadTypeEnum.MATCHES -> StarWarMatchList::class.java
        }
        val fileToString = context.resources.openRawResource(fileId).bufferedReader()
            .use { it.readText() }

        val data = Gson().fromJson(fileToString, TypeToken.get(dataType))
        return data
    }

}