package com.rome4.testfoodrome4.presentation.result_api

import androidx.compose.runtime.Immutable
import kotlinx.coroutines.flow.MutableStateFlow

typealias ResultMutableStateFlow<T> = MutableStateFlow<Result<T>>

@Immutable
sealed class Result<T> {
    fun <R> map(mapper: (T) -> R): Result<R> {
        return when (this) {
            is SuccessResult -> SuccessResult(mapper(this.data))
            is PendingResult -> PendingResult()
            is ErrorResult -> ErrorResult(this.error)
        }
    }

    fun takeSuccess(): T? {
        return (this as? SuccessResult)?.data
    }

    data class SuccessResult<T>(val data: T) : Result<T>()

    class PendingResult<T> : Result<T>()

    data class ErrorResult<T>(val error: Throwable? = null) : Result<T>()
}