package com.example.myapplication.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.core.common.datasource.local.dao.ProductDao
import com.example.myapplication.core.common.datasource.local.entity.ProductEntity

@Database(
    entities = [
        ProductEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}