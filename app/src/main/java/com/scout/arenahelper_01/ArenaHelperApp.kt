package com.scout.arenahelper_01

import android.app.Application
import com.scout.arenahelper_01.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArenaHelperApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArenaHelperApp)
            modules(appModule)
        }
    }
}