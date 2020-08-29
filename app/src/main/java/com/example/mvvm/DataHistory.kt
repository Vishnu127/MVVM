package com.example.mvvm

data class Details(var bank_name: String?="", var amount:String?="" ,var card: Long)

data class DataHistory(
    val num :Array<Details>
)