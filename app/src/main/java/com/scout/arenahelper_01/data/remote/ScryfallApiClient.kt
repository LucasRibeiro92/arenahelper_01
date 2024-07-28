package com.scout.arenahelper_01.data.remote

import com.scout.arenahelper_01.util.Constants.API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScryfallApiClient {
    companion object {
        val apiService: ScryfallApiService by lazy {
            Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ScryfallApiService::class.java)
        }
    }
}