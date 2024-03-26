package com.rome4.testfoodrome4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.rome4.testfoodrome4.presentation.screens.MenuScreen
import com.rome4.testfoodrome4.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MenuScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
