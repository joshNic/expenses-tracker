package com.example.expensestracker.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses_table")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val price: String
)