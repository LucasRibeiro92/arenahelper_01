package com.scout.arenahelper_01.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModel { CardViewModel(get()) }

    // Repository
    single { CardRepository() }
}