package com.training.stockapp.ui.model

import android.content.Context
import androidx.navigation.NavController

data class LoginModel(
    val login: String = "",
    val password: String = "",
    val onLoginTextFieldValueChange: (String) -> Unit = {},
    val onPasswordTextFieldValueChange: (String) -> Unit = {},
    val onLoginButtonClick: (Context, NavController?) -> Unit = {_, _ ->}
)