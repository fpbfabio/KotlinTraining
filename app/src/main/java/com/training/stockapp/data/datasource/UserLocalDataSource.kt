package com.training.stockapp.data.datasource

import com.training.stockapp.data.model.User

class UserLocalDataSource {
    suspend fun signIn(login: String, password: String): Boolean {
        return true
    }

    fun getSignedUser(): User {
        return User(id = "xnfhedb435")
    }
}