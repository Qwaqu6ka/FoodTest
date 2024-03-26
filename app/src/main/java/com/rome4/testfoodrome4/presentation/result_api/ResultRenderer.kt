package com.rome4.testfoodrome4.presentation.result_api

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.rome4.testfoodrome4.R
import com.rome4.testfoodrome4.presentation.components.FoodButton
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import com.rome4.testfoodrome4.presentation.theme.Pink

@Composable
fun <T> SimpleResultRenderer(
    result: Result<T>,
    onTryAgain: () -> Unit,
    modifier: Modifier = Modifier,
    onSuccessResult: @Composable BoxScope.(T) -> Unit
) {
    ResultRenderer(
        result = result,
        onSuccessResult = onSuccessResult,
        onPendingResult = {
            CircularProgressIndicator(
                color = Pink,
                modifier = Modifier.align(Alignment.Center)
            )
        },
        onErrorResult = {
            ErrorResultMessage(onTryAgain = onTryAgain, modifier = Modifier.align(Alignment.Center))
        },
        modifier = modifier
    )
}

@Composable
private fun ErrorResultMessage(onTryAgain: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppTheme.sizes.errorResultContentArrangement)
    ) {
        Text(text = stringResource(R.string.error_result_message))
        FoodButton(text = stringResource(R.string.try_again), onClick = onTryAgain)
    }
}

@Composable
fun <T> ResultRenderer(
    result: Result<T>,
    onSuccessResult: @Composable BoxScope.(T) -> Unit,
    onPendingResult: @Composable BoxScope.() -> Unit,
    onErrorResult: @Composable BoxScope.(Throwable?) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        when (result) {
            is Result.SuccessResult -> onSuccessResult(result.data)
            is Result.PendingResult -> onPendingResult()
            is Result.ErrorResult -> onErrorResult(result.error)
        }
    }
}