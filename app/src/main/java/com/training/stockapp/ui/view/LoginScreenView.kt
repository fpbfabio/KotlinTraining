package com.training.stockapp.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.training.stockapp.R
import com.training.stockapp.ui.model.LoginModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreenView(
    model: LoginModel = LoginModel(),
    navController: NavController? = null
) {
    val context = LocalContext.current
    Scaffold { it ->
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Center)) {
                AsyncImage(
                    modifier = Modifier.align(CenterHorizontally),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.b3.com.br/lumis-theme/br/com/bvmf/internet/theme/bvmf-internet/img/logo-b3-novo.svg")
                        .placeholder(R.drawable.ic_launcher_background)
                        .crossfade(true)
                        .crossfade(1000)
                        .error(R.drawable.ic_launcher_background)
                        .build(), contentDescription = null
                )
                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.spacing_10x)))
                val focusManager = LocalFocusManager.current
                val keyboardController = LocalSoftwareKeyboardController.current
                TextField(
                    modifier = Modifier
                        .align(CenterHorizontally),
                    value = model.login,
                    placeholder = {
                        Text(text = stringResource(id = R.string.login_screen_textfield_login_hint))
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }),
                    onValueChange = { value -> model.onLoginTextFieldValueChange(value) }
                )
                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.spacing_5x))
                )
                TextField(
                    modifier = Modifier
                        .align(CenterHorizontally),
                    value = model.password,
                    placeholder = {
                        Text(text = stringResource(id = R.string.login_screen_textfield_password_hint))
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }),
                    onValueChange = { model.onPasswordTextFieldValueChange(it) }

                )
                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.spacing_5x))
                )
                Button(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = R.dimen.spacing_5x))
                        .align(CenterHorizontally),
                    onClick = {
                        model.onLoginButtonClick(context, navController)
                    }) {
                    Text(text = stringResource(id = R.string.login_screen_button_login_text))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenView()
}