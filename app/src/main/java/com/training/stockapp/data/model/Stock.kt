package com.training.stockapp.data.model

data class Stock(
    val url: String = "",
    val label: String = "Petr4",
    val price: Float = 0f,
    val today: Float = 0f,
    val lastHour: Float = 0f,
    val lastDay: Float = 0f,
    val lastWeek: Float = 0f,
)
