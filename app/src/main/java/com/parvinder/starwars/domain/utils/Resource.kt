package com.parvinder.starwars.domain.utils

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val msg: String) : Resource<Nothing>()
}