package com.training.stockapp.data.repository

import com.training.stockapp.data.datasource.UserLocalDataSource
import com.training.stockapp.data.model.User

class UserRepository(private val localDataSource: UserLocalDataSource) {

    suspend fun signIn(
        login: String,
        password: String
    ): Boolean {
        return localDataSource.signIn(login, password)
    }

    suspend fun getSignedUser() : User {
        return localDataSource.getSignedUser()
    }
}