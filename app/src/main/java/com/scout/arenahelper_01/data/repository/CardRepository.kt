package com.scout.arenahelper_01.data.repository

import android.util.Log
import com.scout.arenahelper_01.data.entity.Card
import com.scout.arenahelper_01.data.remote.ScryfallApiClient

class CardRepository {
    private val apiService = ScryfallApiClient.apiService

    suspend fun searchCards(query: String): List<Card> {
        return try {
            val response = apiService.searchCards(query)
            Log.d("CardRepository", "API response: $response")
            if (response.isSuccessful) {
                response.body()?.data ?: emptyList()
            } else {
                throw Exception("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("CardRepository", "Error fetching cards", e)
            throw e
        }
    }

    // Nova função para obter uma carta específica
    suspend fun getCard(id: String): Card {
        val response = apiService.getCard(id)
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Card not found")
        } else {
            throw Exception(response.message())
        }
    }
}