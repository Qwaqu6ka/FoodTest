package com.rome4.testfoodrome4.presentation.di

import com.rome4.testfoodrome4.presentation.screens.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::MenuViewModel)
}