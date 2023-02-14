package com.training.stockapp.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.training.stockapp.R
import com.training.stockapp.data.repository.UserRepository
import com.training.stockapp.ui.model.LoginModel
import com.training.stockapp.ui.view.AppScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {

    private val _model = MutableStateFlow(
        LoginModel(onLoginButtonClick = { ctx, navController ->
            onLoginButtonClick(
                ctx,
                navController
            )
        }, onPasswordTextFieldValueChange = {
            onPasswordTextFieldValueChange(it)
        }, onLoginTextFieldValueChange = {
            onLoginTextFieldValueChange(it)
        })
    )

    val model = _model.asStateFlow()

    private fun onLoginTextFieldValueChange(value: String) {
        _model.update { m ->
            m.copy(login = value)
        }
    }

    private fun onPasswordTextFieldValueChange(value: String) {
        _model.update { m ->
            m.copy(password = value)
        }
    }

    private fun onLoginButtonClick(context: Context, navController: NavController?) {
        viewModelScope.launch {
            val modelValue = _model.value
            if (userRepository.signIn(modelValue.login, modelValue.password)) {
                navController?.navigate(AppScreen.StockList.name)
            } else {
                Toast.makeText(
                    context,
                    R.string.login_screen_error_toast,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}