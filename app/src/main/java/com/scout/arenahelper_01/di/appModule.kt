package com.scout.arenahelper_01.di

import com.scout.arenahelper_01.data.repository.CardRepository
import com.scout.arenahelper_01.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModel { CardViewModel(get()) }

    // Repository
    single { CardRepository() }
}