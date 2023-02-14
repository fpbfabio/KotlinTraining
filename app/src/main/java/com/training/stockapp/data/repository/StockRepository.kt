package com.training.stockapp.data.repository

import com.training.stockapp.data.datasource.StockLocalDataSource
import com.training.stockapp.data.model.Stock

class StockRepository(private val localDataSource: StockLocalDataSource) {

    fun getStockList(userId: String): List<Stock> {
        return localDataSource.getStocks(userId)
    }
}