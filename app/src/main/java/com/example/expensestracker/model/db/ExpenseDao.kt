package com.example.expensestracker.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expensestracker.model.entity.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense):Long

    @Query("SELECT * FROM expenses_table")
    fun getAllExpenses():LiveData<List<Expense>>
}