package com.example.myapplication.core.common.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.core.common.datasource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query(
        """
            SELECT * FROM products
        """
    )
    fun observeAll(): Flow<List<ProductEntity>>

    @Query(
        """
            SELECT * FROM products
            WHERE id = :id
        """
    )
    fun observeById(
        id: Int
    ): Flow<ProductEntity?>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertProducts(
        products: List<ProductEntity>
    )

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertProduct(
        product: ProductEntity
    )

    @Query(
        """
            DELETE FROM products
        """
    )
    suspend fun clearProducts()

    @Transaction
    suspend fun replaceProducts(
        products: List<ProductEntity>
    ) {
        clearProducts()
        insertProducts(products)
    }
}