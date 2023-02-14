package com.training.stockapp.di

import com.training.stockapp.data.datasource.StockLocalDataSource
import com.training.stockapp.data.datasource.UserLocalDataSource
import com.training.stockapp.data.repository.StockRepository
import com.training.stockapp.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FactoryModule {

    @Singleton
    @Provides
    fun createUserRepository(): UserRepository {
        return UserRepository(UserLocalDataSource())
    }

    @Singleton
    @Provides
    fun createStockRepository(): StockRepository {
        return StockRepository(StockLocalDataSource())
    }
}