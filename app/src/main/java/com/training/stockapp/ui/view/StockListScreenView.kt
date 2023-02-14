package com.training.stockapp.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.stockapp.ui.model.StockListModel
import com.training.stockapp.ui.theme.StockAppTheme


@Composable
fun StockListScreenView(model: StockListModel = StockListModel()) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)) {
        items(model.stockList.size) {
            StockViewItem(stock = model.stockList[it])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StockListScreenPreview() {
    StockAppTheme {
        StockListScreenView()
    }
}