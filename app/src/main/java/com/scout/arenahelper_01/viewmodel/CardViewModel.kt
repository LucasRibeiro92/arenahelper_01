package com.scout.arenahelper_01.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scout.arenahelper_01.data.entity.Card
import com.scout.arenahelper_01.data.repository.CardRepository
import kotlinx.coroutines.launch

class CardViewModel(private val cardRepository: CardRepository) : ViewModel()  {
    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> get() = _cards

    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card> get() = _card

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun searchCards(query: String) {
        viewModelScope.launch {
            try {
                Log.d("CardSearchViewModel", "Searching for cards with query: $query")
                val result = cardRepository.searchCards(query)
                Log.d("CardSearchViewModel", "Search result: $result")
                _cards.value = result
            } catch (e: Exception) {
                Log.e("CardSearchViewModel", "Error searching cards", e)
                _error.value = e.message
            }
        }
    }

    // Nova função para obter uma carta específica
    fun getCard(id: String) {
        viewModelScope.launch {
            try {
                val card = cardRepository.getCard(id)
                _card.value = card
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}