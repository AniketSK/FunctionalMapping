package com.denisbrandi.functionalmapping.domain.model

sealed class Result<out T, out E> {

    data class Success<out T>(val value: T) : Result<T, Nothing>()

    data class Failure<out E>(val error: E) : Result<Nothing, E>()

    inline fun <C> fold(success: (T) -> C, failure: (E) -> C): C = when (this) {
        is Success -> success(value)
        is Failure -> failure(error)
    }

}

typealias SimpleResult<T> = Result<T, Throwable>