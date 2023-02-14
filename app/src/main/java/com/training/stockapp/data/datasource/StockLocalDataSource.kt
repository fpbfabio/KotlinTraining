package com.training.stockapp.data.datasource

import com.training.stockapp.data.model.Stock

class StockLocalDataSource {

    fun getStocks(userId: String) : List<Stock> {
        return listOf(
            Stock(
                url = "https://play-lh.googleusercontent.com/DxCHfCCQZHdX0edn7unbmQXNSvdWST-EK9UeUh8smubt-d6-EQZV94GbK0tL4wXfBVaX",
                label = "PETR4",
                price = 25.8f,
                today = 3.45f,
                lastHour = -2.15f,
                lastDay = 10.45f,
                lastWeek = 50.45f,
            ),
            Stock(
                url = "https://www.anacouto.com.br/wp-content/uploads/2021/07/GALERIA-SITE-AMERICANAS.png",
                label = "AMER3",
                price = 25.8f,
                today = 3.45f,
                lastHour = -2.15f,
                lastDay = 10.45f,
                lastWeek = 50.45f,
            ),
            Stock(
                url = "https://www.sonhoseguro.com.br/wp-content/uploads/2015/01/bradesco-logo.png",
                label = "BBDC4",
                price = 25.8f,
                today = 3.45f,
                lastHour = -2.15f,
                lastDay = 10.45f,
                lastWeek = 50.45f,
            ),
        )
    }
}