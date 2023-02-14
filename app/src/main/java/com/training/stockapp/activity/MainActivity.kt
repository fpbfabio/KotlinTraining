package com.training.stockapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.training.stockapp.ui.model.LoginModel
import com.training.stockapp.ui.theme.StockAppTheme
import com.training.stockapp.ui.view.AppNavigation
import com.training.stockapp.ui.viewmodel.LoginViewModel
import com.training.stockapp.ui.viewmodel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val loginViewModel : LoginViewModel by viewModels()
    val stockViewModel : StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockAppTheme {
                AppNavigation(
                    loginViewModel = loginViewModel,
                    stockViewModel = stockViewModel
                )
            }
        }
    }
}
