package com.example.myapplication.di

import com.example.myapplication.features.products.data.datasource.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ProductDI {
    @Provides
    @Singleton
    fun provideProductApi(
        retrofit: Retrofit
    ): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
}