package com.example.myapplication.core.common

import java.text.NumberFormat

object CurrencyFormatter {
    fun format(price:Double): String {
        return NumberFormat.getCurrencyInstance().format(price)
    }
}