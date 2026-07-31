package com.example.myapplication.core.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.core.common.datasource.local.dao.ProductDao
import com.example.myapplication.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "fake_store.db"
        ).build()
    }

    @Provides
    fun provideProductDao(
        database: AppDatabase
    ): ProductDao {
        return database.productDao()
    }
}