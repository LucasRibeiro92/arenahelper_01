package com.scout.arenahelper_01.data.entity

import com.google.gson.annotations.SerializedName

data class CardSearchResponse(
    @SerializedName("object") val objectType: String,
    @SerializedName("total_cards") val totalCards: Int,
    @SerializedName("has_more") val hasMore: Boolean,
    @SerializedName("next_page") val nextPage: String?,
    val data: List<Card>
)
