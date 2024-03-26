package com.rome4.testfoodrome4.data.di

import com.rome4.testfoodrome4.data.FoodRepository
import com.rome4.testfoodrome4.data.repository.FoodLocalRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::FoodLocalRepository) { bind<FoodRepository>() }
}