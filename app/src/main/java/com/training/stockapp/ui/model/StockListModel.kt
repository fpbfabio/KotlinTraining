package com.training.stockapp.ui.model

import com.training.stockapp.data.model.Stock

data class StockListModel (val stockList: List<Stock> = List(10) { Stock() })