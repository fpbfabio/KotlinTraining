package com.training.stockapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.stockapp.data.repository.StockRepository
import com.training.stockapp.data.repository.UserRepository
import com.training.stockapp.ui.model.StockListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(
    val stockRepository: StockRepository,
    val userRepository: UserRepository
) : ViewModel() {

    private val _model = MutableStateFlow(
        StockListModel()
    )

    val model = _model.asStateFlow()

    init {
        viewModelScope.launch {
            val user = userRepository.getSignedUser()
            val stockList = stockRepository.getStockList(user.id)
            _model.update { m ->
                m.copy(stockList = stockList)
            }
        }
    }
}